package com.StockApp.StockExchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StockExchangeController {
	@Autowired 
	StockExchangeService service = new StockExchangeService();
	
	@PostMapping("/admin/stockexchange/Add")
	public void stockExchangeAdd(@RequestBody StockExchange stock) {
		service.stockExchangeAdder(stock);
	}
	
	@GetMapping("/admin/stockexchange/get")
	public List<StockExchange> getStockExchange(){
		List<StockExchange> list = service.StockExchangeGetter();
		return list;
	}
	
	@GetMapping("admin/stockexchange/get/{stockExchangeId}")
	public StockExchange getStockExchangeById(@PathVariable Integer stockExchangeId)
	{
		return service.StockExchangeByIdGetter(stockExchangeId);
	}
	
}
