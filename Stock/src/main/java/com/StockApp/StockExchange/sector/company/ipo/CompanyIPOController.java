package com.StockApp.StockExchange.sector.company.ipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyIPOController {
	@Autowired
	CompanyIPOService service = new CompanyIPOService();
	
	@PostMapping("/admin/company/ipo/add")
	public void addCompanyIPO(@RequestBody CompanyIPO ipo) {
		service.companyIPOAdder(ipo);
	}
	@RequestMapping("/user/company/ipo/{companyId}")
	public List<CompanyIPO> getCompanyIPO(@PathVariable Integer companyId){
		return service.companyIPOGetter(companyId);
	}
}
