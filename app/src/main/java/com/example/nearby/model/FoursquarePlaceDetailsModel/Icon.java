package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class Icon{

	@SerializedName("prefix")
	private String prefix;

	@SerializedName("suffix")
	private String suffix;

	public String getPrefix(){
		return prefix;
	}

	public String getSuffix(){
		return suffix;
	}
}