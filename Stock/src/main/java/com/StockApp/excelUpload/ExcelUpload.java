package com.StockApp.excelUpload;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

abstract class ExcelUpload implements Excel {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
	  static String SHEET = "company";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }
	  
}
