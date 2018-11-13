package com.example.user.androidnetworking.model.randomresponse;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class RandomResponse{

	@SerializedName("results")
	private List<User> results;

	@SerializedName("info")
	private Info info;

	public void setResults(List<User> results){
		this.results = results;
	}

	public List<User> getResults(){
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
			"RandomResponse{" + 
			"results = '" + results + '\'' + 
			",info = '" + info + '\'' + 
			"}";
		}
}