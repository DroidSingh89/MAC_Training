package com.example.user.androidnetworking.model.randomresponse;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Info{

	@SerializedName("seed")
	private String seed;

	@SerializedName("page")
	private int page;

	@SerializedName("results")
	private int results;

	@SerializedName("version")
	private String version;

	public void setSeed(String seed){
		this.seed = seed;
	}

	public String getSeed(){
		return seed;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}

	@Override
 	public String toString(){
		return 
			"Info{" + 
			"seed = '" + seed + '\'' + 
			",page = '" + page + '\'' + 
			",results = '" + results + '\'' + 
			",version = '" + version + '\'' + 
			"}";
		}
}