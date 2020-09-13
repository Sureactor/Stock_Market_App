package com.StockApp.exception;

public class StockException extends RuntimeException {
	String message;

	public StockException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
