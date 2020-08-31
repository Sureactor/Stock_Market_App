package com.StockApp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	

	
}
