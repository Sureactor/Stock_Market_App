package com.StockApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(StockException.class)
	@ResponseBody
	public ResponseEntity<StockException> stockException(StockException excep){
		System.out.println("++++++++++++++++++++");
		return new ResponseEntity<StockException>(excep,HttpStatus.OK);
	}
}
