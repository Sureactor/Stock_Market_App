package com.StockApp.StockExchange.sector.company.stock;

import java.sql.Date;
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
	
	public List<Stock> stockComparer(Integer companyId,Date from,Date to){
		List<Stock> list = repo.findByDate(companyId, from, to);
		return list;
	}
	 /*
	public Double sectorStockGetter(List<Integer> companyId, Date from) {
		// TODO Auto-generated method stub
		Double d=repo.findSectorStock(companyId,from);
		return d;
	}
	*/
}
