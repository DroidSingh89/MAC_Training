package com.example.user.androidnetworking.model;

public class Timezone{
	private String offset;
	private String description;

	public void setOffset(String offset){
		this.offset = offset;
	}

	public String getOffset(){
		return offset;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"Timezone{" + 
			"offset = '" + offset + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}
