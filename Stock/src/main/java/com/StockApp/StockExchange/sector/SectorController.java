package com.StockApp.StockExchange.sector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StockApp.StockExchange.StockExchange;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SectorController {

	@Autowired
	SectorService sectorservice =new SectorService();
	

	@GetMapping("/user/sectordetails")
	public List<SectorDetails> getSectors(){
		List<SectorDetails> list=sectorservice.SectorsGetter();
		return list;
	}
	
	@PostMapping("/user/sector")
	public void add(@RequestBody Sector sec) {
		sectorservice.Add(sec);
	}
	
}
