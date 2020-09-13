package com.StockApp.User;

import java.util.Random;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.email.*;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	@Autowired
	Email mailobj;
	
	public boolean validateUser(String username,String password){
		User user = repo.findByUsernameAndPassword(username,password);
		if(user==null)
			return false;
		else
			return true;
	}
	public boolean check(String email) throws AddressException, MessagingException{
		//User user = repo.findByUsernameAndEmail(username,email);
		User user = repo.findByEmail(email);
		if(user==null)
			return false;
		else
		{
			int n = 10000 + new Random().nextInt(90000);
			user.setForgottoken(Integer.toString(n));
			repo.save(user);
			String subject="StockApp: Password reset request";
			String body="OTP for password change is "+Integer.toString(n);;
			EmailAttribute obj= new EmailAttribute(email,subject,body);
			mailobj.sendMail(obj);
			return true;
			
		}
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return true;
	}

	

	public boolean passwordUpdate(String email, User user) {
		// TODO Auto-generated method stub
		System.out.print(email+ user.getUsername());
		User userobj = repo.findByEmail(email); 
		//User userobj = repo.findByUsername(username);
		System.out.print(email+ userobj.getUsername());
		userobj.setPassword(user.getPassword()); 
		System.out.print("password changed");
		repo.save(userobj);
		return true;
		
	}

	public boolean validateAdmin(String username, String password) {
		// TODO Auto-generated method stub
		if(username.equals("admin") && password.equals("admin"))
			return true;
		else
			return false;
	}

	public void profileUpdate(String username, User user) {
		// TODO Auto-generated method stub
		User userobj = repo.findByUsername(username); 
		userobj.setEmail(user.getEmail()); 
		userobj.setMobile(user.getMobile()); 
		repo.save(userobj);
	}

	public String sendemail(String email) {
		// TODO Auto-generated method stub
		User userobj = repo.findByEmail(email); 
		if(userobj!=null)
			return "Check your email for the link";
		else
			return "no";
	}
	public boolean tokengetter(String email, String token) {
		// TODO Auto-generated method stub
		User user = repo.findByEmail(email);
		if(token.equals(user.getForgottoken()))
		return true;
		else
			return false;
	}
	

	
}
