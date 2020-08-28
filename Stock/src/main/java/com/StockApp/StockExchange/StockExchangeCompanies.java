package com.StockApp.StockExchange;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockExchangeCompanies {
	
	@Id
	Integer stockExchangeId;
	String companyId;
	public StockExchangeCompanies(Integer stockExchangeId, String companyId) {
		super();
		this.stockExchangeId = stockExchangeId;
		this.companyId = companyId;
	}
	public Integer getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(Integer stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	
}
