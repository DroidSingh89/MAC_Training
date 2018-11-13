package com.example.user.androidnetworking.model;

public class Id{
	private String name;
	private String value;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Id{" + 
			"name = '" + name + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}
