package com.example.nearby.model.FoursquareImageModel;

import com.google.gson.annotations.SerializedName;

public class Checkin{

	@SerializedName("createdAt")
	private int createdAt;

	@SerializedName("timeZoneOffset")
	private int timeZoneOffset;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	public int getCreatedAt(){
		return createdAt;
	}

	public int getTimeZoneOffset(){
		return timeZoneOffset;
	}

	public String getId(){
		return id;
	}

	public String getType(){
		return type;
	}
}