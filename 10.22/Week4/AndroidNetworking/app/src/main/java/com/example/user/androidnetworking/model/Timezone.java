package com.example.user.androidnetworking.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Timezone{

	@SerializedName("offset")
	private String offset;

	@SerializedName("description")
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