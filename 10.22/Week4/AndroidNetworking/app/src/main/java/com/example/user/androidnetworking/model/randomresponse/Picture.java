package com.example.user.androidnetworking.model.randomresponse;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Picture{

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("large")
	private String large;

	@SerializedName("medium")
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