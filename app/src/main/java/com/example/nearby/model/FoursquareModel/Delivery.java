package com.example.nearby.model.FoursquareModel;

import com.google.gson.annotations.SerializedName;

public class Delivery{

	@SerializedName("provider")
	private Provider provider;

	@SerializedName("id")
	private String id;

	@SerializedName("url")
	private String url;

	public Provider getProvider(){
		return provider;
	}

	public String getId(){
		return id;
	}

	public String getUrl(){
		return url;
	}
}