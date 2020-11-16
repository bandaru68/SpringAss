package com.common.ash.model;

public class LibraryModel {
	
	private int id;
	private String name;
	private int year;
	
	public LibraryModel() {
		
	}
	
	public LibraryModel(int id, String name, int year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getYear() {
		return this.year;
	}
	
	@Override
	public String toString() {
		return "Id : "+this.getId()+"\tName : "+this.getName()+"\tYear : "+this.getName();
	}
	
}
