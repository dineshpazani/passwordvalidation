package com.password.validator.rules;

import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharValidator implements Callable<Boolean>{	
	
	private String password;
	public CharValidator(String password){
		this.password = password;
	}
	
	public boolean atleastLowercase() throws InterruptedException {
		Pattern pattern = Pattern.compile(".*[a-z].*");
		Matcher m = pattern.matcher(this.password);
		if(m.find())return true; else throw new IllegalArgumentException("Atleast one lower case required!");

	}
	
	public boolean atleastUppercase() throws InterruptedException {
		Pattern pattern = Pattern.compile(".*[A-Z].*");
		Matcher m = pattern.matcher(this.password);
		if(m.find())return true; else throw new IllegalArgumentException("Atleast one upper case required!");

	}
	
	public boolean atleastNumbercase() throws InterruptedException {
		Pattern pattern = Pattern.compile(".*[0-9].*");
		Matcher m = pattern.matcher(this.password);
		if(m.find())return true; else throw new IllegalArgumentException("Atleast one number required!");

	}
	@Override
	public Boolean call() throws Exception {
		return atleastLowercase() ||
				atleastUppercase() ||
				atleastNumbercase();
	}
}
