package com.StockApp.StockExchange.sector.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository repo;
	public void companyAdder(Company company) {
		repo.save(company);
	}
}
