package com.example.sprbatch.model;

public class CycleInstance {

	private int cycleCodeTc;
	
	private int yearTc;

	@Override
	public String toString() {
		return "CycleInstance [cycleCodeTc=" + cycleCodeTc + ", yearTc=" + yearTc + "]";
	}

	public CycleInstance(int cycleCodeTc, int yearTc) {
		super();
		this.cycleCodeTc = cycleCodeTc;
		this.yearTc = yearTc;
	}

	public CycleInstance() {
		// TODO Auto-generated constructor stub
	}

	public int getCycleCodeTc() {
		return cycleCodeTc;
	}

	public void setCycleCodeTc(int cycleCodeTc) {
		this.cycleCodeTc = cycleCodeTc;
	}

	public int getYearTc() {
		return yearTc;
	}

	public void setYearTc(int yearTc) {
		this.yearTc = yearTc;
	}
	
	
}
