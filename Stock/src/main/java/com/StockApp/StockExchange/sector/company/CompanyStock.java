package com.StockApp.StockExchange.sector.company;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyStock {
	@Id
	Integer companyId;
	Integer stockId;
	public CompanyStock() {
		
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	
	
}
