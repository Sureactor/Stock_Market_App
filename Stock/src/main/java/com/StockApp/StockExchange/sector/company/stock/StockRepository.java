package com.StockApp.StockExchange.sector.company.stock;

import java.sql.Date;
import java.util.List;
import java.lang.Double;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.StockApp.QueryClass;

public interface StockRepository extends CrudRepository<Stock,Integer>,JpaRepository<Stock,Integer>{
	public List<Stock> findByCompanyCompanyId(Integer companyId);
	
	@Query(value = "SELECT new com.StockApp.QueryClass(SUM(s.closePrice),s.date) FROM Stock s WHERE s.date BETWEEN cast(?1 as date) AND cast(?2 as date) AND s.company.companyId IN ?3 GROUP BY s.date")
	public List<QueryClass> findByDateAndCompanyId(Date from,Date to,List<Integer>lis);
	
	
	@Query(value="FROM Stock s WHERE s.date BETWEEN cast(?2 as date) AND cast(?3 as date) AND s.company.companyId=?1")
	public List<Stock> findByDate(Integer companyId,Date from,Date to);


}
