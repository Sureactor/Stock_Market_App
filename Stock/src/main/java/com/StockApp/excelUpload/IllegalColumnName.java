package com.StockApp.excelUpload;

public class IllegalColumnName extends Exception{
	String s;

	public IllegalColumnName(String s) {
		super(s);
	}
	
}
