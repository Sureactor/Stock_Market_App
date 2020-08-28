package com.StockApp.StockExchange.sector.company.stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	@Autowired
	StockService service = new StockService();
	@RequestMapping("/user/company/{id}")
	public List<Stock> getStockByCompanyId(@PathVariable Integer id){
//		List<Stock> list = service.StockGetterByCompanyId(id);
		return null;
		
	}
	
	@PostMapping("/admin/company/stock/add")
	public void addStock(@RequestBody Stock stock) {
		service.stockAdder(stock);
	}
}
