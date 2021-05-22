package com.example.nearby.model.FoursquareModel;

import com.google.gson.annotations.SerializedName;

public class Provider{

	@SerializedName("name")
	private String name;

	@SerializedName("icon")
	private Icon icon;

	public String getName(){
		return name;
	}

	public Icon getIcon(){
		return icon;
	}
}