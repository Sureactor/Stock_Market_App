package com.StockApp.StockExchange.sector.company.ipo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CompanyIPORepository extends CrudRepository<CompanyIPO,Integer> {
	public List<CompanyIPO> findByCompanyCompanyId(Integer companyId);

	@Query(value="FROM CompanyIPO s WHERE s.closeTime >= ?1 ")
	public List<CompanyIPO> findByDate(Date current);
}
