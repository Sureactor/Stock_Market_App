package com.StockApp.excelUpload;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.StockExchange.sector.company.stock.Stock;

public class StockExcel implements Excel {
	List<Stock> stockList;
	Stock stock;

	public StockExcel() {
		this.stockList = new ArrayList<>();
	}

	public List<Stock> saveToDb() {
		System.out.println("object :"+this.stockList);
		return this.stockList;
	}

	@Override
	public void createObject() {
		this.stock = new Stock();
	}
	
	@Override
	public void pushToList() {
		this.stockList.add(this.stock);
		
	}
	
	@Override
	public void setParameters(Cell cell,int key) throws Exception{
		switch(key){
		case 0:
			createObject();
            stock.setStockId(Integer.valueOf((int)cell.getNumericCellValue()));
            break;

          case 1:
            stock.setClosePrice(Double.valueOf(cell.getNumericCellValue()));
            break;

          case 2:
            stock.setCompanyTurnover(Double.valueOf(cell.getNumericCellValue()));
            break;

          case 3:
            stock.setDate(cell.getDateCellValue());
            break;
            
          case 4:
        	  stock.setOpenPrice(Double.valueOf(cell.getNumericCellValue()));
        	  break;
          case 5:
        	  stock.setStockExchangeId(Integer.valueOf((int)cell.getNumericCellValue()));
        	  break;
          case 6:
        	  stock.setTime(Time.valueOf(cell.getStringCellValue()));
        	  break;
          case 7:
        	  Company comp= new Company();
        	  comp.setCompanyId(Integer.valueOf((int)cell.getNumericCellValue()));
        	  stock.setCompany(comp);
        	  pushToList();
//        	  this.company = null;
        	  break;
		}
	}

}
