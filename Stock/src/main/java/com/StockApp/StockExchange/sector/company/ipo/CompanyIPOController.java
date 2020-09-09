package com.StockApp.StockExchange.sector.company.ipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CompanyIPOController {
	@Autowired
	CompanyIPOService service = new CompanyIPOService();
	
	@PostMapping("/admin/company/ipo/add")
	public void addCompanyIPO(@RequestBody CompanyIPO ipo) {
		service.companyIPOAdder(ipo);
	}
	@RequestMapping("/user/company/ipo")
	public List<CompanyIPO> getCompanyIPO(){
		return service.companyIPOGetter();
	}
	
	@RequestMapping("/user/company/ipolatest")
	public List<CompanyIPO> getCompanyIPOnewlatest(){
		return service.companyIPOGetterlatest();
	}
	
	@PutMapping("/admin/company/ipo/update")
	public void updateCompanyIPO(@RequestBody CompanyIPO ipo) {
		service.companyIPOAdder(ipo);
	}
}
