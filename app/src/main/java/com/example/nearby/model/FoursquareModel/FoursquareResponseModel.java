package com.example.nearby.model.FoursquareModel;

import com.google.gson.annotations.SerializedName;

public class FoursquareResponseModel{

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