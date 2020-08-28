package com.StockApp.StockExchange.sector.company.stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	@Autowired
	StockRepository repo;
	public List<Stock> StockGetterByCompanyId(Integer id){
		List<Stock> list = new ArrayList<>();
//		return repo.findByCompanyId(id);
		return null;
	}
	
	public void stockAdder(Stock stock) {
		repo.save(stock);
	}
}
