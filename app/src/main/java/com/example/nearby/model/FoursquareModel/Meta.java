package com.example.nearby.model.FoursquareModel;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("code")
	private int code;

	@SerializedName("requestId")
	private String requestId;

	public int getCode(){
		return code;
	}

	public String getRequestId(){
		return requestId;
	}
}