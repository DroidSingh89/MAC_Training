package com.example.user.androidnetworking.model.randomresponse;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class User {

	@SerializedName("nat")
	private String nat;

	@SerializedName("gender")
	private String gender;

	@SerializedName("phone")
	private String phone;

	@SerializedName("dob")
	private Dob dob;

	@SerializedName("name")
	private Name name;

	@SerializedName("registered")
	private Registered registered;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private Id id;

	@SerializedName("login")
	private Login login;

	@SerializedName("cell")
	private String cell;

	@SerializedName("email")
	private String email;

	@SerializedName("picture")
	private Picture picture;

	public void setNat(String nat){
		this.nat = nat;
	}

	public String getNat(){
		return nat;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setDob(Dob dob){
		this.dob = dob;
	}

	public Dob getDob(){
		return dob;
	}

	public void setName(Name name){
		this.name = name;
	}

	public Name getName(){
		return name;
	}

	public void setRegistered(Registered registered){
		this.registered = registered;
	}

	public Registered getRegistered(){
		return registered;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(Id id){
		this.id = id;
	}

	public Id getId(){
		return id;
	}

	public void setLogin(Login login){
		this.login = login;
	}

	public Login getLogin(){
		return login;
	}

	public void setCell(String cell){
		this.cell = cell;
	}

	public String getCell(){
		return cell;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPicture(Picture picture){
		this.picture = picture;
	}

	public Picture getPicture(){
		return picture;
	}

	@Override
 	public String toString(){
		return 
			"User{" +
			"nat = '" + nat + '\'' + 
			",gender = '" + gender + '\'' + 
			",phone = '" + phone + '\'' + 
			",dob = '" + dob + '\'' + 
			",name = '" + name + '\'' + 
			",registered = '" + registered + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",login = '" + login + '\'' + 
			",cell = '" + cell + '\'' + 
			",email = '" + email + '\'' + 
			",picture = '" + picture + '\'' + 
			"}";
		}
}