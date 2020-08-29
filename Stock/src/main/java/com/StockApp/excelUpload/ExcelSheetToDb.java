package com.StockApp.excelUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.StockApp.StockExchange.sector.company.Company;

public class ExcelSheetToDb extends ExcelUpload {

	
	public static List<Company> excelToTutorials(MultipartFile file) throws InvalidFormatException {
		try {
			  Path tempDir = Files.createTempDirectory("");
//			  File convFile = new File(file.getOriginalFilename());
			  File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
			  file.transferTo(tempFile);
//			  FileInputStream fis= new FileInputStream(convFile);
//			  Workbook wb = new org.apache.poi.xssf.usermodel.XSSFWorkbook(fis);
		      Workbook workbook = new XSSFWorkbook(tempFile);

		      Sheet sheet = workbook.getSheetAt(0);
		      Iterator<Row> rows = sheet.iterator();

		      List<Company> companyList = new ArrayList<Company>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        Company company = new Company();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		            company.setCompanyId((int) currentCell.getNumericCellValue());
		            break;

		          case 1:
		            company.setBrief(currentCell.getStringCellValue());
		            break;

		          case 2:
		            company.setCeo(currentCell.getStringCellValue());
		            break;

		          case 3:
		            company.setCode(Integer.toString((int) currentCell.getNumericCellValue()));
		            break;
		            
		          case 4:
		        	  company.setContactId(Integer.toString((int) currentCell.getNumericCellValue()));
		          
		          case 5:
		        	  company.setName(Integer.toString((int) currentCell.getNumericCellValue()));
		        	  
		          case 6:
		        	  company.setSectorId(Integer.toString((int) currentCell.getNumericCellValue()));
		        	  
		          case 7:
		        	  company.setStockExchangeId(Integer.toString((int) currentCell.getNumericCellValue()));

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        companyList.add(company);
		      }

		      workbook.close();

		      return companyList;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
	}

	
}
