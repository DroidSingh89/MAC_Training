package com.example.user.androidnetworking.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Location{

	@SerializedName("city")
	private String city;

	@SerializedName("street")
	private String street;

	@SerializedName("timezone")
	private Timezone timezone;

	@SerializedName("postcode")
	private String postcode;

	@SerializedName("coordinates")
	private Coordinates coordinates;

	@SerializedName("state")
	private String state;

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setTimezone(Timezone timezone){
		this.timezone = timezone;
	}

	public Timezone getTimezone(){
		return timezone;
	}

	public void setPostcode(String postcode){
		this.postcode = postcode;
	}

	public String getPostcode(){
		return postcode;
	}

	public void setCoordinates(Coordinates coordinates){
		this.coordinates = coordinates;
	}

	public Coordinates getCoordinates(){
		return coordinates;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"city = '" + city + '\'' + 
			",street = '" + street + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",postcode = '" + postcode + '\'' + 
			",coordinates = '" + coordinates + '\'' + 
			",state = '" + state + '\'' + 
			"}";
		}
}