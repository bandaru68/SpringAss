package com.common.ash.model;

public class ElectricModel {
	
	private double initialReading;
	private double MonthReading;
	public static final double COST_PER_UNIT = 2.4;
	private double totalBill;
	
	public ElectricModel(){
		
	}
	
	public ElectricModel(double initialReading, double MonthReading){
		this.initialReading = initialReading;
		this.MonthReading = MonthReading;
	}

	public void setInitialReading(double initialReading) {
		this.initialReading = initialReading;
	}

	public void setMonthReading(double MonthReading) {
		this.MonthReading = MonthReading;
	}
	
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	public double getInitialReading() {
		return this.initialReading;
	}
	
	public double getMonthReading() {
		return this.MonthReading;
	}
	
	public double getTotalBill() {
		return this.totalBill;
	}
	
	@Override
	public String toString() {
		return "Total Bill : "+this.getTotalBill();
	}
}
