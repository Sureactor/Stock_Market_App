package com.StockApp.StockExchange;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockExchange {
	@Id
	private Integer stockExchangeId;
	private String brief;
	private String remarks;
	private String contactId;
	public StockExchange(String stockExchangeId, String brief, String remarks, String contactId) {
		super();
		this.stockExchangeId = stockExchangeId;
		this.brief = brief;
		this.remarks = remarks;
		this.contactId = contactId;
	}
	public String getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(String stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	
	
	
}
