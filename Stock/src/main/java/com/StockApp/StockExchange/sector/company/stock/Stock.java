package com.StockApp.StockExchange.sector.company.stock;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
	@Id
	Integer stockId;
	double closePrice;
	double companyTurnover;
	Date date;
	LocalDateTime dateTime;
	double openPrice;
	String companyId;
	String stockExchangeId;
	public Stock(String stockId, double closePrice, double companyTurnover, Date date, LocalDateTime dateTime,
			double openPrice, String companyId, String stockExchangeId) {
		super();
		this.stockId = stockId;
		this.closePrice = closePrice;
		this.companyTurnover = companyTurnover;
		this.date = date;
		this.dateTime = dateTime;
		this.openPrice = openPrice;
		this.companyId = companyId;
		this.stockExchangeId = stockExchangeId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
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
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(String stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	
	
}
