package com.StockApp.excelUpload;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.StockExchange.sector.company.CompanyRepository;

@Service
public class ExcelService {
	@Autowired
	CompanyRepository repo;
	
	public void saveExcel(MultipartFile file) throws InvalidFormatException {
		List<Company> company = ExcelSheetToDb.excelToTutorials(file);
		repo.saveAll(company);
	}
}
