package com.example.nearby.model.FoursquareModel;

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