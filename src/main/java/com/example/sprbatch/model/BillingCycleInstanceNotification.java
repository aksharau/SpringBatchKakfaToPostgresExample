package com.example.sprbatch.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class BillingCycleInstanceNotification {
	
	@Override
	public String toString() {
		return "BillingCycleInstanceNotification [cycleCode=" + cycleCode + ", year=" + year + "]";
	}

	@JsonProperty("cycleCode")
	private int cycleCode;
	
	@JsonProperty("year")
	private int year;

	@JsonProperty("cycleCode")
	public int getCycleCode() {
		return cycleCode;
	}

	@JsonProperty("cycleCode")
	public void setCycleCode(int cycleCode) {
		this.cycleCode = cycleCode;
	}

	@JsonProperty("year")
	public int getYear() {
		return year;
	}

	@JsonProperty("year")
	public void setYear(int year) {
		this.year = year;
	}

	



	
}
