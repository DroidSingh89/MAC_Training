package com.example.user.androidnetworking.model.randomresponse;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Name{

	@SerializedName("last")
	private String last;

	@SerializedName("title")
	private String title;

	@SerializedName("first")
	private String first;

	public void setLast(String last){
		this.last = last;
	}

	public String getLast(){
		return last;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setFirst(String first){
		this.first = first;
	}

	public String getFirst(){
		return first;
	}

	@Override
 	public String toString(){
		return 
			"Name{" + 
			"last = '" + last + '\'' + 
			",title = '" + title + '\'' + 
			",first = '" + first + '\'' + 
			"}";
		}
}