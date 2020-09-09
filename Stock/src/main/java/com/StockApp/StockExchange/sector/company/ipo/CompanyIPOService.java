package com.StockApp.StockExchange.sector.company.ipo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockApp.StockExchange.StockExchange;
import com.StockApp.StockExchange.sector.company.stock.Stock;

@Service
public class CompanyIPOService {
	@Autowired
	CompanyIPORepository repo;
	public List<CompanyIPO> companyIPOGetter(){
		List<CompanyIPO> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}
	
	public void companyIPOAdder(CompanyIPO ipo) {
		repo.save(ipo);
	}

	public List<CompanyIPO> companyIPOGetterlatest() {
		// TODO Auto-generated method stub
		//LocalDate current=java.time.LocalDate.now();
		long millis=System.currentTimeMillis();  
        Date current=new java.sql.Date(millis);  
		List<CompanyIPO> list = repo.findByDate(current);
		return list;
		
	}
}
