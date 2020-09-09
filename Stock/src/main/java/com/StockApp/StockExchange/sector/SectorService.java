package com.StockApp.StockExchange.sector;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockApp.StockExchange.StockExchange;

@Service
public class SectorService {

	@Autowired
	SectorDetailsRepository repo;
	
	@Autowired
	SectorRepository repo1;
	public List<SectorDetails> SectorsGetter() {
		// TODO Auto-generated method stub
		List<SectorDetails> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}
	
	public void Add(Sector sec) {
		repo1.save(sec);
	}
	

}
