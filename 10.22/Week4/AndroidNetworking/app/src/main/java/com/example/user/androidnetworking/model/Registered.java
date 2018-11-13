package com.example.user.androidnetworking.model;

public class Registered{
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
			"Registered{" + 
			"date = '" + date + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}
