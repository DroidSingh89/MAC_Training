package com.example.user.androidnetworking.model;

public class Picture{
	private String thumbnail;
	private String large;
	private String medium;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setLarge(String large){
		this.large = large;
	}

	public String getLarge(){
		return large;
	}

	public void setMedium(String medium){
		this.medium = medium;
	}

	public String getMedium(){
		return medium;
	}

	@Override
 	public String toString(){
		return 
			"Picture{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",large = '" + large + '\'' + 
			",medium = '" + medium + '\'' + 
			"}";
		}
}
