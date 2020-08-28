package com.StockApp.StockExchange.sector.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
	@Autowired
	CompanyService service = new CompanyService();
	
	@PostMapping("/admin/StockExhchange/company/add")
	public void addCompany(@RequestBody Company company) {
		service.companyAdder(company);
	}
	
}
