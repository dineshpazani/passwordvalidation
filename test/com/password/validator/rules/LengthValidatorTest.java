package com.password.validator.rules;


public class LengthValidatorTest {
	public static void main(String[] args) throws InterruptedException {
		testLengthValidation();
	}
	
	public static void testLengthValidation() throws InterruptedException {
		LengthValidator lv = new LengthValidator("mypasswprd");
		Boolean v = lv.lengthValidation();
		if(v == true) {
			System.out.println("Assertion is true!");
		}else {
			System.out.println("Assertion is false!");
		}
		
	}

}
