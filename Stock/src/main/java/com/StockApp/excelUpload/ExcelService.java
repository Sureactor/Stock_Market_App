package com.StockApp.excelUpload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.StockExchange.sector.company.CompanyRepository;
import com.StockApp.StockExchange.sector.company.stock.StockRepository;

@Service
public class ExcelService {
	@Autowired
	CompanyRepository compRepo;
	@Autowired
	StockRepository stockRepo;
	
	
	public void saveToRepo(String object,List list) {
		switch(object){
		case "COMPANY":
			compRepo.saveAll(list);
			break;
		case "STOCK":
			stockRepo.saveAll(list);
			break;
		}
	}
	public void saveExcel(MultipartFile file,String table) throws Exception {
		List list = ExcelSheetToDb.excelToTutorials(file,table);
		saveToRepo(table,list);
	}
}
