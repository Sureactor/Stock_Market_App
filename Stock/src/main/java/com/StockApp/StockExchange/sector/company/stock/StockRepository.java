package com.StockApp.StockExchange.sector.company.stock;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends CrudRepository<Stock,Integer>,JpaRepository<Stock,Integer>{
	public List<Stock> findByCompanyCompanyId(Integer companyId);
	
	@Query(value="FROM Stock s WHERE s.date BETWEEN ?2 AND ?3 AND s.company.companyId=?1")
	public List<Stock> findByDate(Integer companyId,Date from,Date to);
}
