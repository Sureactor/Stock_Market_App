package com.StockApp.StockExchange.sector.company.ipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyIPOService {
	@Autowired
	CompanyIPORepository repo;
	public List<CompanyIPO> companyIPOGetter(Integer companyId){
		return repo.findByCompanyCompanyId(companyId);
	}
	
	
	public void companyIPOAdder(CompanyIPO ipo) {
		repo.save(ipo);
	}
}
