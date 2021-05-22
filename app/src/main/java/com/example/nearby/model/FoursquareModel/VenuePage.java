package com.example.nearby.model.FoursquareModel;

import com.google.gson.annotations.SerializedName;

public class VenuePage{

	@SerializedName("id")
	private String id;

	public String getId(){
		return id;
	}
}