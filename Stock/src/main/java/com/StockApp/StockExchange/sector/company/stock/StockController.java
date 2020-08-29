package com.StockApp.StockExchange.sector.company.stock;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	@Autowired
	StockService service = new StockService();
	@RequestMapping("/user/company/{companyId}")
	public List<Stock> getStockByCompanyId(@PathVariable Integer companyId){
		List<Stock> list = service.StockGetterByCompanyId(companyId);
		return list;
		
	}
	
	@PostMapping("/admin/company/stock/add")
	public void addStock(@RequestBody Stock stock) {
		service.stockAdder(stock);
	}
	
	@GetMapping("/user/company/stock/{companyId}/{from}/{to}")
	public List<Stock> compareStock(@PathVariable Integer companyId,@PathVariable Date from,@PathVariable Date to){
		return service.stockComparer(companyId, from, to);
	}
}
