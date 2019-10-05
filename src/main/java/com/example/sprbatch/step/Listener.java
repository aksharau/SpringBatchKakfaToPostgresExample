package com.example.sprbatch.step;
import org.springframework.batch.core.ItemReadListener;

import com.example.sprbatch.model.BillingCycleInstanceNotification;


public class Listener implements ItemReadListener<String>{

	public void beforeRead() {
		// TODO Auto-generated method stub
		System.out.println("before read called");
		
	}

	public void afterRead(String item) {
		System.out.println("after read called" + item );
	}

	public void onReadError(Exception ex) {
		System.out.print("The exception is" + ex.getMessage());
	}

}
