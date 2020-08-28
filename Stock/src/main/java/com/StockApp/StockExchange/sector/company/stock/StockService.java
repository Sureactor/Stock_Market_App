package com.StockApp.StockExchange.sector.company.stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	@Autowired
	StockRepository repo;
	public List<Stock> StockGetterByCompanyId(Integer companyId){
		List<Stock> list = new ArrayList<>();
		return repo.findByCompanyCompanyId(companyId);
	}
	
	public void stockAdder(Stock stock) {
		repo.save(stock);
	}
	
	public List<List<String>> companyDetailsGetter(Integer companyId,String date1, String date2){
		List<Stock> stock = repo.findByCompanyCompanyId(companyId);
		
		return null;
		
	}
}
