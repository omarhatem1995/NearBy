package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class Colors{

	@SerializedName("highlightColor")
	private HighlightColor highlightColor;

	@SerializedName("algoVersion")
	private int algoVersion;

	@SerializedName("highlightTextColor")
	private HighlightTextColor highlightTextColor;

	public HighlightColor getHighlightColor(){
		return highlightColor;
	}

	public int getAlgoVersion(){
		return algoVersion;
	}

	public HighlightTextColor getHighlightTextColor(){
		return highlightTextColor;
	}
}