package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class FoursquarePlaceDetailsResponseModel{

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