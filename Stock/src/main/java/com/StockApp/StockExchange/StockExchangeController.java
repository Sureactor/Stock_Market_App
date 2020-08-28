package com.StockApp.StockExchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockExchangeController {
	@Autowired 
	StockExchangeService service = new StockExchangeService();
	
	@PostMapping("/admin/StockExchange/Add")
	public void stockExchangeAdd(@RequestBody StockExchange stock) {
		service.stockExchangeAdder(stock);
	}
	
	@GetMapping("/admin/StockExchange/get")
	public List<StockExchange> getStockExchange(){
		List<StockExchange> list = service.StockExchangeGetter();
		return list;
	}
}
