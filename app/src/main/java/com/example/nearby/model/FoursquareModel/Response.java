package com.example.nearby.model.FoursquareModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("confident")
	private boolean confident;

	@SerializedName("venues")
	private List<VenuesItem> venues;

	public boolean isConfident(){
		return confident;
	}

	public List<VenuesItem> getVenues(){
		return venues;
	}
}