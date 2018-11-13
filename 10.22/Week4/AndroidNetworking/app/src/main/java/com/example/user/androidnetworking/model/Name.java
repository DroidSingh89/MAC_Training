package com.example.user.androidnetworking.model;

public class Name{
	private String last;
	private String title;
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
