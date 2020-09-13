package com.StockApp.User;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.StockExchange.sector.company.CompanyService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService service = new UserService();
	
	
	@PostMapping("/user/login")
	public boolean loginUser(@RequestBody User user) {
		return service.validateUser(user.getUsername(),user.getPassword());
	}
	@PostMapping("/user/forgotpassword")
	public boolean checker(@RequestBody User user) throws AddressException, MessagingException {
		return service.check(user.getEmail());
	}
	
	@PostMapping("/user/gettoken")
	public boolean gettoken(@RequestBody User user) throws AddressException, MessagingException {
		return service.tokengetter(user.getEmail(),user.getForgottoken());
	}
	@PostMapping("/admin/login")
	public boolean loginAdmin(@RequestBody Admin admin) {
		return service.validateAdmin(admin.getUsername(),admin.getPassword());
	}
	@PostMapping("/user/signup")
	public boolean signin(@RequestBody User user) {
		return service.addUser(user);
	}
	
	//@RequestMapping(method=RequestMethod.PUT, value="/user/forgot")
	@PostMapping("/user/forgot")
	public boolean updatePassword(@RequestBody User user) {
		 return service.passwordUpdate(user.getEmail(),user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/updateprofile/{username}")
	public void updateProfile(@RequestBody User user,@PathVariable String username) {
		 service.profileUpdate(username,user);
	}
	/*
	@RequestMapping(method=RequestMethod.POST, value="/user/forgotpassword")
	public String forgotPassword(@RequestBody User user) {
		return service.sendemail(user.getEmail());
		
	}
	*/
	
}
