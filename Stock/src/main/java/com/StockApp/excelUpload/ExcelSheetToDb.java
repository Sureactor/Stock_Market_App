package com.StockApp.excelUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.multipart.MultipartFile;

import com.StockApp.StockExchange.sector.company.Company;

public class ExcelSheetToDb {

	static Excel excel;
	
	
	public static <T> List<T> excelToTutorials(MultipartFile file,String table) throws IllegalColumnName,EntityNotFoundException,Exception {
		try {
			  Path tempDir = Files.createTempDirectory("");
			  File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
			  file.transferTo(tempFile);
		      Workbook workbook = new XSSFWorkbook(tempFile);

		      Sheet sheet = workbook.getSheetAt(0);
		      Iterator<Row> rows = sheet.iterator();

		      ExcelFactory factory = new ExcelFactory();
		      excel = factory.objectCreator(table);
		      int rowNumber = 0;
		      FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		      List<String> l= new ArrayList<>();
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();
		        	
		
		        

		        Iterator<Cell> cellsInRow = currentRow.iterator();


		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		        	
		          Cell currentCell = cellsInRow.next();
		          if (rowNumber == 0) {
		        	  System.out.println("+++++++++++"+currentCell);
			          l.add(currentCell.getStringCellValue());
			          continue;
			        }
		          excel.setParameters(currentCell, cellIdx);
		          cellIdx++;
		        }
		        if(rowNumber == 0 && !excel.check(l)) {

		        	System.out.println("Excepiton");
		        	throw new IllegalColumnName("attribute error");
		        }
		        rowNumber +=1;
		        System.out.println("Here");
		      }
		      List list = excel.saveToDb();
		      workbook.close();
		      return list;

		    } 
		catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
	}
	
//
	
}
