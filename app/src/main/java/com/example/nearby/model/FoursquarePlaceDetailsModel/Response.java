package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("venue")
	private Venue venue;

	public Venue getVenue(){
		return venue;
	}
}