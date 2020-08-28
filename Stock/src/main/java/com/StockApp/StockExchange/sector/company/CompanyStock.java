package com.StockApp.StockExchange.sector.company;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyStock {
	@Id
	Integer companyId;
	String stockId;
	public CompanyStock(Integer companyId, String stockId) {
		super();
		this.companyId = companyId;
		this.stockId = stockId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	
	
}
