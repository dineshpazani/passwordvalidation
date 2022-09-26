package com.password.validator.app;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.password.validator.rules.CharValidator;
import com.password.validator.rules.LengthValidator;;

public class PasswordValidatorApp {


    public static void main(String args[]) throws InterruptedException,
                                           ExecutionException {
    	String password = "MyPassword12345";
    	
    	LengthValidator lengthValidator = new LengthValidator(password);
    	CharValidator charValidator = new CharValidator(password);
    	
    	 FutureTask<Boolean> futureTask1=new FutureTask<>(lengthValidator);
         FutureTask<Boolean> futureTask2=new FutureTask<>(charValidator);
         
         ExecutorService executor = Executors.newFixedThreadPool(2);
         executor.execute(futureTask1);
         executor.execute(futureTask2);
         
         while(true)
         {
             try {
                 if(!futureTask1.isDone())
                 {
                     System.out.println("FutureTask1 output="+futureTask1.get());
                 }
                 if(!futureTask2.isDone())                 {
                     System.out.println("FutureTask2 output="+futureTask2.get());
                 }
                 if(futureTask1.isDone() && futureTask2.isDone())
                 {
                     System.out.println("Completed both the FutureTasks, shutting down the executors");
                     executor.shutdown();
                     return;
                 }
             }
             catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (ExecutionException e) {
                 e.printStackTrace();
             }
         }
    }

}



