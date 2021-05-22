package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("displayValue")
	private String displayValue;

	@SerializedName("displayName")
	private String displayName;

	public String getDisplayValue(){
		return displayValue;
	}

	public String getDisplayName(){
		return displayName;
	}
}