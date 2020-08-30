package com.StockApp.excelUpload;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.StockExchange.sector.company.CompanyRepository;


public class companyExcel implements Excel {
	
	@Autowired
	CompanyRepository rep;
	List<Company> companyList;
	Company company;
	
	public companyExcel() {
		this.companyList = new ArrayList<>();
	}

	
	
	
	public List<Company> saveToDb() {
		System.out.println("object :"+this.companyList);
		for(int i=0;i<companyList.size();i++) {
			System.out.println("ceo "+companyList.get(i).getCeo());
		}
		return this.companyList;
	}

	@Override
	public void createObject() {
		this.company = new Company();
	}
	
	@Override
	public void pushToList() {
		this.companyList.add(this.company);
		
	}
	
	@Override
	public void setParameters(Cell cell,int i) {
		switch(i){
		case 0:
			createObject();
            company.setCompanyId(Integer.valueOf((int)cell.getNumericCellValue()));
            break;

          case 1:
            company.setBrief(cell.getStringCellValue());
            break;

          case 2:
            company.setCeo(cell.getStringCellValue());
            break;

          case 3:
            company.setCode(Integer.toString((int) cell.getNumericCellValue()));
            break;
            
          case 4:
        	  company.setContactId(Integer.valueOf((int)cell.getNumericCellValue()));
        	  break;
          case 5:
        	  company.setName(cell.getStringCellValue());
        	  break;
          case 6:
        	  company.setSectorId(Integer.valueOf((int)cell.getNumericCellValue()));
        	  break;
          case 7:
        	  company.setStockExchangeId(Integer.valueOf((int)cell.getNumericCellValue()));
        	  pushToList();
//        	  this.company = null;
        	  break;
		}
	}

}