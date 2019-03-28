package com.nedu;

public class LoginException extends RuntimeException {
	
	public LoginException(){
		
	}
	
	public LoginException(String msg){
		super(msg);
	}
}
