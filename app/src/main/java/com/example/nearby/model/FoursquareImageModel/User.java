package com.example.nearby.model.FoursquareImageModel;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("countryCode")
	private String countryCode;

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getCountryCode(){
		return countryCode;
	}
}