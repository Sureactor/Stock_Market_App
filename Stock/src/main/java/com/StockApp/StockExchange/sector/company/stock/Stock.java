package com.StockApp.StockExchange.sector.company.stock;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.StockApp.StockExchange.sector.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","company"})
@Entity
public class Stock {
	@Id
	Integer stockId;
	double closePrice;
	double companyTurnover;
	Date date;
	LocalDateTime dateTime;
	double openPrice;
	String stockExchangeId;
	
	
	@ManyToOne
	@JoinColumn(name="companyId")
	Company company;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	public Stock() {
		
	}
//	public Stock(Integer stockId, double closePrice, double companyTurnover, Date date, LocalDateTime dateTime,
//			double openPrice, String companyId, String stockExchangeId,Company company) {
//		super();
//		this.stockId = stockId;
//		this.closePrice = closePrice;
//		this.companyTurnover = companyTurnover;
//		this.date = date;
//		this.dateTime = dateTime;
//		this.openPrice = openPrice;
//		this.companyId = companyId;
//		this.stockExchangeId = stockExchangeId;
//		}
	
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public double getCompanyTurnover() {
		return companyTurnover;
	}
	public void setCompanyTurnover(double companyTurnover) {
		this.companyTurnover = companyTurnover;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public String getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(String stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	
	
}
