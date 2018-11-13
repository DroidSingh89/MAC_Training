package com.example.user.androidnetworking.model;

public class Location{
	private String city;
	private String street;
	private Timezone timezone;
	private int postcode;
	private Coordinates coordinates;
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

	public void setPostcode(int postcode){
		this.postcode = postcode;
	}

	public int getPostcode(){
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
