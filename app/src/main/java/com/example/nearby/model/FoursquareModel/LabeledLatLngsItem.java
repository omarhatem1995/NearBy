package com.example.nearby.model.FoursquareModel;

import com.google.gson.annotations.SerializedName;

public class LabeledLatLngsItem{

	@SerializedName("lng")
	private double lng;

	@SerializedName("label")
	private String label;

	@SerializedName("lat")
	private double lat;

	public double getLng(){
		return lng;
	}

	public String getLabel(){
		return label;
	}

	public double getLat(){
		return lat;
	}
}