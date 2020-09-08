package com.StockApp.User;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.StockApp.StockExchange.sector.company.Company;


@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	
	public boolean validateUser(String username,String password){
		User user = repo.findByUsernameAndPassword(username,password);
		if(user==null)
			return false;
		else
			return true;
	}
	public String check(String username,String email){
		User user = repo.findByUsernameAndEmail(username,email);
		if(user==null)
			return "Invalid email id";
		else
		{
			JavaMailSender mailSender = null;
			user.setForgottoken(UUID.randomUUID().toString());
			repo.save(user);
			String appUrl = "http://localhost:8081";
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("cooper.hauck@ethereal.email");
			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
					+ "/reset?token=" + user.getForgottoken());
			
			mailSender.send(passwordResetEmail);
			return "check your mail";
			
		}
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return true;
	}

	

	public void passwordUpdate(String username, User user) {
		// TODO Auto-generated method stub
		User userobj = repo.findByUsername(username); 
		userobj.setPassword(user.getPassword()); 
		repo.save(userobj);
		
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
	

	
}
