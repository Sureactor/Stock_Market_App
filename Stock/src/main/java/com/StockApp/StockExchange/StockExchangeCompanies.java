package com.StockApp.StockExchange;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockExchangeCompanies {
	
	@Id
	Integer stockExchangeId;
	String companyId;
	public StockExchangeCompanies(String stockExchangeId, String companyId) {
		super();
		this.stockExchangeId = stockExchangeId;
		this.companyId = companyId;
	}
	public String getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(String stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	
}
