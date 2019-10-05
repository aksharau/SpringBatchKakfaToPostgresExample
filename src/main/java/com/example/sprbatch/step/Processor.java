package com.example.sprbatch.step;

import org.springframework.batch.item.ItemProcessor;

import com.example.sprbatch.model.BillingCycleInstanceNotification;
import com.example.sprbatch.model.CycleInstance;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Processor implements ItemProcessor<String, CycleInstance>  {
	
	  public CycleInstance process(String inputCycleInstanceStr) throws Exception {
			CycleInstance outputCycleInstance = new CycleInstance();

		 try {
		  ObjectMapper mapper = new ObjectMapper();
		 
		  BillingCycleInstanceNotification inputCycleInstance = mapper.readValue(inputCycleInstanceStr, BillingCycleInstanceNotification.class);
		outputCycleInstance.setCycleCodeTc(inputCycleInstance.getCycleCode());
		outputCycleInstance.setYearTc(inputCycleInstance.getYear());
			  
	    System.out.println("Converting (" + inputCycleInstance + ") into (" + outputCycleInstance + ")");
		 }
		 catch(com.fasterxml.jackson.core.JsonParseException ex)
		 {
			 System.out.println("Unexpected format, ignoring :" + ex.getMessage());
		 }
	    return outputCycleInstance;
	  }

}
