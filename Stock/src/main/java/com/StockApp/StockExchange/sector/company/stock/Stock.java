package com.StockApp.StockExchange.sector.company.stock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.StockApp.StockExchange.sector.company.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Stock {
	@Id
	Integer stockId;
	double closePrice;
	double companyTurnover;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "UTC")
	Date date;
	Time time;
//	String dateTime;

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
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
	public void setDate(String date) throws ParseException {
//		SimpleDateFormat ft = 
//			      new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
//		 
//		this.date = ft.parse(date);
		this.date = Date.valueOf(date);
	}
//	
//	public String getDateTime() {
//	hh:mm:ss a zzz
//		return dateTime;
//	}
//
//	public void setDateTime(String dateTime) {
//		this.dateTime = dateTime;
//	}

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
