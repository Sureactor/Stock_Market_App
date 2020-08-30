package com.StockApp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.StockExchange.sector.company.CompanyService;


@RestController

public class UserController {
	
	@Autowired
	UserService service = new UserService();
	
	
	@PostMapping("/user/login")
	public boolean loginUser(@RequestBody User user) {
		return service.validateUser(user.getUsername(),user.getPassword());
	}
	
	@PostMapping("/admin/login")
	public boolean loginAdmin(@RequestBody Admin admin) {
		return service.validateAdmin(admin.getUsername(),admin.getPassword());
	}
	@PostMapping("/user/signup")
	public boolean signin(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/forgot/{username}")
	public void updatePassword(@RequestBody User user,@PathVariable String username) {
		 service.passwordUpdate(username,user);
	}
}
