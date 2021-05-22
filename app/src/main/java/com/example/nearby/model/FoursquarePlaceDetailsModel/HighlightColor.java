package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class HighlightColor{

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