package com.StockApp.excelUpload;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelController {
	@Autowired
	ExcelService service = new ExcelService();
	
	@PostMapping("/admin/comapny/addExcel")
	public void addTodb(@RequestParam("File") MultipartFile file) throws InvalidFormatException {
		service.saveExcel(file);
	}
}
