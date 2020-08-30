package com.StockApp.StockExchange.sector.company;

import org.springframework.data.repository.CrudRepository;



public interface CompanyRepository extends CrudRepository<Company,Integer>{

		List<Company> findBySectorId(Integer sectorId);

}
