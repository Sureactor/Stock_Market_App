package com.StockApp.StockExchange.sector.company.ipo;

import java.sql.Date;

import java.text.ParseException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.StockApp.StockExchange.sector.company.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class CompanyIPO {
	@Id
	Integer ipoId;
	Date openTime;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "UTC")
	Date closeTime;
	String remarks;
	double sharePrice;
	int totalShares;
	@ManyToOne
	@JoinColumn(name="companyId")
	Company company;
	
	public CompanyIPO() {
		
	}
	public Integer getIpoId() {
		return ipoId;
	}
	public void setIpoId(Integer ipoId) {
		this.ipoId = ipoId;
	}
	/*
	public String getOpenTime() {
>>>>>>> 41c101653f51886c74fbaecbdc20c49de35e6d78
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = Date.valueOf(openTime);
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = Date.valueOf(closeTime);
	}
	*/
	
	public String getRemarks() {
		return remarks;
	}
	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String d) throws ParseException {
		this.openTime = Date.valueOf(d);
	}
	
	
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String d) throws ParseException {
		this.closeTime = Date.valueOf(d);
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	public int getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
}
