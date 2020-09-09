package com.StockApp.excelUpload;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.StockApp.StockExchange.sector.company.Company;
import com.StockApp.StockExchange.sector.company.CompanyRepository;

@Service
public interface Excel {
	public void pushToList();
	public <T> List<T> saveToDb();
	public void createObject();
	void setParameters(Cell currentCell, int i) throws Exception;
	public boolean check(List<String> l);
}
