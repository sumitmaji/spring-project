package com.sum.hr.server.hrexception;

public class HrException extends Exception{

	public HrException(String message){
		super(message);
	}
	
	public HrException(String message, Throwable cause){
		super(message,cause);
	}
}
