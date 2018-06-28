package com.example.user.geocodingdaggermvp.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class AddressComponentsItem{

	@SerializedName("types")
	private List<String> types;

	@SerializedName("short_name")
	private String shortName;

	@SerializedName("long_name")
	private String longName;

	public void setTypes(List<String> types){
		this.types = types;
	}

	public List<String> getTypes(){
		return types;
	}

	public void setShortName(String shortName){
		this.shortName = shortName;
	}

	public String getShortName(){
		return shortName;
	}

	public void setLongName(String longName){
		this.longName = longName;
	}

	public String getLongName(){
		return longName;
	}

	@Override
 	public String toString(){
		return 
			"AddressComponentsItem{" + 
			"types = '" + types + '\'' + 
			",short_name = '" + shortName + '\'' + 
			",long_name = '" + longName + '\'' + 
			"}";
		}
}