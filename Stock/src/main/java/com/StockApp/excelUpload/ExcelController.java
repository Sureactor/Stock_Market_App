package com.StockApp.excelUpload;

import javax.persistence.EntityNotFoundException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ExcelController {
	@Autowired
	ExcelService service = new ExcelService();
	
	
	@PostMapping("/admin/company/addExcel")
	public String addTodb(@RequestParam("File") MultipartFile file,@RequestParam("Table") String table) throws IllegalColumnName,EntityNotFoundException, Exception {
		String s;
		service.saveExcel(file,table);
		s="success";
		return s;
		
	}
}
