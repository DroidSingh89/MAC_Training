package com.example.user.androidnetworking.model;

import java.util.List;

public class Response{
	private List<ResultsItem> results;
	private Info info;

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setInfo(Info info){
		this.info = info;
	}

	public Info getInfo(){
		return info;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"results = '" + results + '\'' + 
			",info = '" + info + '\'' + 
			"}";
		}
}