package com.StockApp.StockExchange.sector.company.ipo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.exception.StockException;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CompanyIPOController {
	@Autowired
	CompanyIPOService service = new CompanyIPOService();
	
	void checkValidity(CompanyIPO c,BindingResult bind) throws StockException{
		StringBuilder sb = new StringBuilder();
		if(bind.hasErrors()) {
			System.out.println("here babay");
			bind.getAllErrors().forEach(s->sb.append(s.getDefaultMessage()+", "));
			throw new StockException(sb.toString());
		}
	}
	
	@PostMapping("/admin/company/ipo/add")
	public void addCompanyIPO(@Valid @RequestBody CompanyIPO ipo,BindingResult bind) {
		checkValidity(ipo,bind);
		service.companyIPOAdder(ipo);
		throw new StockException("IPO Addedd!!");
	}
	@RequestMapping("/user/company/ipo/{id}")
	public List<CompanyIPO> getCompanyIPO(@PathVariable Integer id){
		return service.companyIPOGetter(id);
	}
	
	@RequestMapping("/user/company/ipolatest")
	public List<CompanyIPO> getCompanyIPOnewlatest(){
		return service.companyIPOGetterlatest();
	}
	
	@PutMapping("/admin/company/ipo/update")
	public void updateCompanyIPO(@Valid @RequestBody CompanyIPO ipo,BindingResult bind) {
		checkValidity(ipo,bind);
		service.companyIPOAdder(ipo);
		throw new StockException("IPO updated!");
	}
	@RequestMapping("/user/company/ipo/get/{id}")
	public CompanyIPO getIPObyId(@PathVariable Integer id){
		return service.ipoGetter(id);
	}
	
	
	
}
