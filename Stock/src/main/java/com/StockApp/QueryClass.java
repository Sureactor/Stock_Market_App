package com.StockApp;

import java.util.Date;

public class QueryClass {
	
	public double closePrice;
	public Date date;
	public QueryClass(double closePrice,Date date){
		this.closePrice = closePrice;
		this.date= date;
	}
}
