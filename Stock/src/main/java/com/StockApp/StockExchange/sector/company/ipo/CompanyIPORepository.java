package com.StockApp.StockExchange.sector.company.ipo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CompanyIPORepository extends CrudRepository<CompanyIPO,Integer> {
	public List<CompanyIPO> findByCompanyCompanyId(Integer companyId);
}
