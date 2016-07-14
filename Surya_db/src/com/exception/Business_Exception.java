package com.exception;

public class Business_Exception extends Exception implements ErrorMessage{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Business_Exception(String err){
	 super(err);	 
 }
}
