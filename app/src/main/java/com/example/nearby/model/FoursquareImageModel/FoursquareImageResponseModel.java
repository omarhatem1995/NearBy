package com.example.nearby.model.FoursquareImageModel;

import com.google.gson.annotations.SerializedName;

public class FoursquareImageResponseModel{

	@SerializedName("meta")
	private Meta meta;

	@SerializedName("response")
	private Response response;

	public Meta getMeta(){
		return meta;
	}

	public Response getResponse(){
		return response;
	}
}