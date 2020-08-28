package com.StockApp.StockExchange.sector.company;

import javax.persistence.Entity;

@Entity
public class Company {
	@javax.persistence.Id
	Integer Id;
	String ceo;
	String brief;
	String code;
	String name;
	String contactId;
	String sectorId;
	String stockExchangeId;
	public Company(String id, String ceo, String brief, String code, String name, String contactId, String sectorId,
			String stockExchangeId) {
		super();
		Id = id;
		this.ceo = ceo;
		this.brief = brief;
		this.code = code;
		this.name = name;
		this.contactId = contactId;
		this.sectorId = sectorId;
		this.stockExchangeId = stockExchangeId;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getSectorId() {
		return sectorId;
	}
	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}
	public String getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(String stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	
	
}
