package com.StockApp.StockExchange.sector;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sector {
	
	@Id
	Integer sectorId;
	String companyId;
	public Sector(String sectorId, String companyId) {
		super();
		this.sectorId = sectorId;
		this.companyId = companyId;
	}
	public String getSectorId() {
		return sectorId;
	}
	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	
}
