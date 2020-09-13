package com.StockApp.email;

public class EmailAttribute {
	private String address;
	private String subject;
	private String body;
	public EmailAttribute(String email, String subject2, String body2) {
		// TODO Auto-generated constructor stub
		this.address=email;
		this.subject=subject2;
		this.body=body2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
