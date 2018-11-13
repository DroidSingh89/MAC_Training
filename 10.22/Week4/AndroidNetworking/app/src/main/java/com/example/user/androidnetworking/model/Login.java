package com.example.user.androidnetworking.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Login{

	@SerializedName("sha1")
	private String sha1;

	@SerializedName("password")
	private String password;

	@SerializedName("salt")
	private String salt;

	@SerializedName("sha256")
	private String sha256;

	@SerializedName("uuid")
	private String uuid;

	@SerializedName("username")
	private String username;

	@SerializedName("md5")
	private String md5;

	public void setSha1(String sha1){
		this.sha1 = sha1;
	}

	public String getSha1(){
		return sha1;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setSalt(String salt){
		this.salt = salt;
	}

	public String getSalt(){
		return salt;
	}

	public void setSha256(String sha256){
		this.sha256 = sha256;
	}

	public String getSha256(){
		return sha256;
	}

	public void setUuid(String uuid){
		this.uuid = uuid;
	}

	public String getUuid(){
		return uuid;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setMd5(String md5){
		this.md5 = md5;
	}

	public String getMd5(){
		return md5;
	}

	@Override
 	public String toString(){
		return 
			"Login{" + 
			"sha1 = '" + sha1 + '\'' + 
			",password = '" + password + '\'' + 
			",salt = '" + salt + '\'' + 
			",sha256 = '" + sha256 + '\'' + 
			",uuid = '" + uuid + '\'' + 
			",username = '" + username + '\'' + 
			",md5 = '" + md5 + '\'' + 
			"}";
		}
}