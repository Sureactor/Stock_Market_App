package com.StockApp.StockExchange.sector;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SectorDetails {

	@Id
	Integer sectorId;
	String name;
	String brief;
	
	
	public SectorDetails() {
		super();
	}
	public SectorDetails(Integer sectorId, String name, String brief) {
		super();
		this.sectorId = sectorId;
		this.name = name;
		this.brief = brief;
	}
	public Integer getSectorId() {
		return sectorId;
	}
	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	
}
