package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class Stats{

	@SerializedName("tipCount")
	private int tipCount;

	public int getTipCount(){
		return tipCount;
	}
}