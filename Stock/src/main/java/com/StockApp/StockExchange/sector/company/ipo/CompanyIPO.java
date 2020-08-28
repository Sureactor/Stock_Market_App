package com.StockApp.StockExchange.sector.company.ipo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.StockApp.StockExchange.sector.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class CompanyIPO {
	@Id
	Integer ipoId;
	String openTime;
	String closeTime;
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
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getRemarks() {
		return remarks;
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
