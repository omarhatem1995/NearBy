package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class HighlightTextColor{

	@SerializedName("photoId")
	private String photoId;

	@SerializedName("value")
	private int value;

	public String getPhotoId(){
		return photoId;
	}

	public int getValue(){
		return value;
	}
}