package com.password.validator.rules;

import java.util.concurrent.Callable;


public class LengthValidator implements Callable<Boolean>{	
	
	private String password;
	public LengthValidator(String password){
		this.password = password;
	}
	
	public boolean lengthValidation() throws InterruptedException {
		if(this.password.length() > 8)return true; else throw new IllegalArgumentException("Invalid password length!");

	}
	
	public boolean nullValidation() throws InterruptedException {
		if(this.password != null)return true; else throw new IllegalArgumentException("password is null!");

	}

	@Override
	public Boolean call() throws Exception {
		return lengthValidation() && nullValidation();
	}
}