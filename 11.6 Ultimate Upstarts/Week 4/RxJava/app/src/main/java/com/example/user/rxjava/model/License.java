package com.example.user.rxjava.model;

import com.google.gson.annotations.SerializedName;

public class License{

	@SerializedName("name")
	private String name;

	@SerializedName("spdx_id")
	private String spdxId;

	@SerializedName("key")
	private String key;

	@SerializedName("url")
	private String url;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSpdxId(String spdxId){
		this.spdxId = spdxId;
	}

	public String getSpdxId(){
		return spdxId;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"License{" + 
			"name = '" + name + '\'' + 
			",spdx_id = '" + spdxId + '\'' + 
			",key = '" + key + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}