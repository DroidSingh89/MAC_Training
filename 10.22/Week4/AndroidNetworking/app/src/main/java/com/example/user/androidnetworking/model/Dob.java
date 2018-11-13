package com.example.user.androidnetworking.model;

public class Dob{
	private String date;
	private int age;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	@Override
 	public String toString(){
		return 
			"Dob{" + 
			"date = '" + date + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}
