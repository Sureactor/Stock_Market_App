package com.StockApp.StockExchange.sector.company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository repo;
	public void companyAdder(Company company) {
		repo.save(company);
	}
	
	public Company CompanyByIdGetter(Integer companyId){
		Company comp = repo.findById(companyId).get();
		return comp;
	}
	
	public void companyUpdater(Company company) {
		repo.save(company);
	}
	
	public void companyDeleter(Integer companyId) {
		repo.deleteById(companyId);
	}

	public List<Company> CompanyBySectorGetter(Integer sectorId) {
		// TODO Auto-generated method stub
		List<Company> comp = repo.findBySectorId(sectorId);
		return comp;
		 
	}
}
