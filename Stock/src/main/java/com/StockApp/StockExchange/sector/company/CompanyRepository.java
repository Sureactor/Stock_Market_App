package com.StockApp.StockExchange.sector.company;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;





public interface CompanyRepository extends CrudRepository<Company,Integer>{
	

	@Query(value="SELECT companyId FROM Company s WHERE s.sectorId=?1")
	List<Integer> findIdBySectorId(Integer sectorId);


		List<Company> findBySectorId(Integer sectorId);



		List<Company> findBySectorIdAndStockExchangeId(Integer sectorId, Integer exchangeId);

}
