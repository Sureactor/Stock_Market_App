package com.StockApp.StockExchange.sector.company.stock;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock,Integer>{
	public List<Stock> findByCompanyCompanyId(Integer companyId);
	
}
