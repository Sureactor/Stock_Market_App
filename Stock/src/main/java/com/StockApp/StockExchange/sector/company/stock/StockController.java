package com.StockApp.StockExchange.sector.company.stock;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockApp.QueryClass;
import com.StockApp.StockExchange.sector.company.CompanyService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StockController {
	@Autowired
	StockService service = new StockService();
	@Autowired
	CompanyService companyservice=new CompanyService();
	@RequestMapping("/user/company/{companyId}")
	public List<Stock> getStockByCompanyId(@PathVariable Integer companyId){
		List<Stock> list = service.StockGetterByCompanyId(companyId);
		return list;
		
	}
	
	@PostMapping("/admin/company/stock/add")
	public void addStock(@RequestBody Stock stock) {
		service.stockAdder(stock);
	}
	
	@GetMapping("/user/company/stock/{from}/{to}")
	public List<QueryClass> getSectorPrice(@PathVariable Integer companyId,@PathVariable Date from,@PathVariable Date to){
		Integer[] a = {21,22};
		List<Integer> list = Arrays.asList(a);
		return service.sectorPriceGetter(from, to,list);
	
	}
	
	@GetMapping("/user/company/{companyId}/{from}/{to}")
	public List<Stock> compareCompany(@PathVariable Integer companyId,@PathVariable Date from,@PathVariable Date to){
		return service.companyStockComparer(companyId, from, to);
	}
	

	@GetMapping("/user/sector/stock/{sectorId}/{from}/{to}")
	public List<QueryClass> getsectorStock(@PathVariable Integer sectorId,@PathVariable Date from,@PathVariable Date to)
	{
		List<Integer> companyId=companyservice.CompanyIdBySectorGetter(sectorId);
	    return service.sectorStockGetter(companyId,from,to);
		
	}


	/*
	@PostMapping("/user/sector/stock/{from}/{to}")
	public List<sectorstock> sectorStockGetter(@RequestBody List<Integer> companyId,@PathVariable Date from,@PathVariable Date to)
	{
		List<sectorstock> list=new ArrayList<sectorstock>();
		Double d = service.sectorStockGetter(companyId, from);
		sectorstock s= new sectorstock(from,d);
		Double d2 = service.sectorStockGetter(companyId, to);
		sectorstock s2= new sectorstock(to,d2);
		list.add(s);
		list.add(s2);
		return list;
		//return service.sectorStockGetter(companyId, from, to);
		/*
		for (Date date = from; date.before(to); date = date.plusDays(1))
		{
		    date.
		}
		*/
}
