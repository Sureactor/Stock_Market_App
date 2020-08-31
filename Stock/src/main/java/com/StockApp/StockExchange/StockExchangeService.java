package com.StockApp.StockExchange;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockExchangeService {
	@Autowired
	StockExchangeRepository repo;
	public void stockExchangeAdder(StockExchange stockExchange) {
		repo.save(stockExchange);
	}	
	
	public List<StockExchange> StockExchangeGetter(){
		List<StockExchange> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}

	public StockExchange StockExchangeByIdGetter(Integer stockExchangeId) {
		StockExchange stockexchange=repo.findById(stockExchangeId).get();
		return stockexchange;
	}
}
