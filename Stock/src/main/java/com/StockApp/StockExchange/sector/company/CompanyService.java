package com.StockApp.StockExchange.sector.company;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockApp.exception.StockException;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository repo;
	public void companyAdder(Company company) throws StockException {
		if(repo.existsById(company.getId())) {
			throw new StockException("ID already exist");
		}
		repo.save(company);
		System.out.println(repo);
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
	
	public List<Company> AllCompanyGetter(){
		List<Company> list = new ArrayList<>();
		repo.findAll().forEach(list::add); 
		return list;
	}
	public List<Company> CompanyGetter(){
		List<Company> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}
	
	
	public List<Integer> CompanyIdBySectorGetter(Integer sectorId) {
		// TODO Auto-generated method stub
		List<Integer> comp = repo.findIdBySectorId(sectorId);
		return comp;
	}

	public List<Company> CompanyBySectorExchangeGetter(Integer sectorId, Integer exchangeId) {
		// TODO Auto-generated method stub
		List<Company> comp=repo.findBySectorIdAndStockExchangeId(sectorId,exchangeId);
		return comp;
	}
	
	public List<String> companyNameGetter(){
		return repo.findCompanyName();
	}
	

}
