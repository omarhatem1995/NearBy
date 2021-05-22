package com.example.nearby.model.FoursquareImageModel;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("photos")
	private Photos photos;

	public Photos getPhotos(){
		return photos;
	}
}