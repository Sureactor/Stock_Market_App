package com.StockApp.excelUpload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockApp.StockExchange.sector.company.CompanyRepository;

@Service
public class ExcelFactory {
	@Autowired
	CompanyRepository repo;
	
	public Excel objectCreator(String object) {
		switch(object){
			case "COMPANY" :
				return new companyExcel();
			case "STOCK" :
				return new StockExcel();
		}
		return new companyExcel();
	}
	
	
}
