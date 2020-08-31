package com.StockApp.StockExchange.sector.company;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.StockApp.StockExchange.StockExchange;
import com.StockApp.StockExchange.sector.company.ipo.CompanyIPO;
import com.StockApp.StockExchange.sector.company.stock.Stock;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","stock","companyIPO"})
@Entity
public class Company {
	@Id
	Integer companyId;
	String ceo;
	String brief;
	String code;
	String name;
	Integer contactId;
	Integer sectorId;
	Integer stockExchangeId;
	
	public Company() {}
	
	
	public Company(Integer id, String ceo, String brief, String code, String name, Integer contactId, Integer sectorId,
			Integer stockExchangeId,Stock stock) {
		super();
		this.companyId = id;
		this.ceo = ceo;
		this.brief = brief;
		this.code = code;
		this.name = name;
		this.contactId = contactId;
		this.sectorId = sectorId;
		this.stockExchangeId = stockExchangeId;
	}
	
	
	@OneToMany(mappedBy="company")
	Set<Stock> stock;


	
	@OneToMany(mappedBy="company")
	Set<CompanyIPO> companyIPO;
	
	@ManyToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<StockExchange> stockexchange = new HashSet<>();
	
	public void setStockexchange(Set<StockExchange> stockexchange) {
		this.stockexchange = stockexchange;
	}
	
	public Set<StockExchange> getStockexchange() {
		return stockexchange;
	}

	
	public Integer getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}


	public Set<Stock> getStock() {
		return stock;
	}


	public void setStock(Set<Stock> stock) {
		this.stock = stock;
	}


	public Integer getId() {
		return companyId;
	}
	public void setId(Integer id) {
		this.companyId = id;
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
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public Integer getSectorId() {
		return sectorId;
	}
	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}
	public Integer getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(Integer stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	
	
}
