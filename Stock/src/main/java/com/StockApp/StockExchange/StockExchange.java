package com.StockApp.StockExchange;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.StockApp.StockExchange.sector.company.Company;

import javax.persistence.JoinColumn;

@Entity
public class StockExchange{
	@Id
	private Integer stockExchangeId;
	private String brief;
	private String remarks;
	private String contactId;
		
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "stockexchange_company",
            joinColumns = {
                    @JoinColumn(name = "stock_exchange_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "company_id")})
    private Set<Company> company = new HashSet<>();
	
	
	public Set<Company> getCompany() {
		return company;
	}
	public void setCompany(Set<Company> company) {
		this.company = company;
	}
	public StockExchange() {
		
	}
	public StockExchange(Integer stockExchangeId, String brief, String remarks, String contactId) {
		super();
		this.stockExchangeId = stockExchangeId;
		this.brief = brief;
		this.remarks = remarks;
		this.contactId = contactId;
	}
	public Integer getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(Integer stockExchangeId) {
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
