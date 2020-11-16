package com.common.model;

public class LoginModel {
	
	private String name;
	private String pwd;
	
	public LoginModel() {
		
	}
	
	public LoginModel(String name, String age) {
		this.name = name;
		this.pwd = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(String pwd) {
		this.pwd = pwd;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPwd() {
		return this.pwd;
	}
	
	@Override
	public String toString() {
		return "Name : "+this.getName()+"\tAge : "+this.getPwd();
	}
	
}
