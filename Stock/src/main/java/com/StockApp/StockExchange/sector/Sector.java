package com.StockApp.StockExchange.sector;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.StockApp.StockExchange.sector.company.Company;

@Entity
public class Sector {
	
	@Id
	Integer sectorId;
	Integer companyId;
	
	public Sector() {
		
	}
	public Sector(Integer sectorId, Integer companyId) {
		super();
		this.sectorId = sectorId;
		this.companyId = companyId;
	}
	public Integer getSectorId() {
		return sectorId;
	}
	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	
}
