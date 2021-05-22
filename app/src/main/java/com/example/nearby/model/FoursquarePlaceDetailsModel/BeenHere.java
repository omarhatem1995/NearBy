package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class BeenHere{

	@SerializedName("marked")
	private boolean marked;

	@SerializedName("count")
	private int count;

	@SerializedName("unconfirmedCount")
	private int unconfirmedCount;

	@SerializedName("lastCheckinExpiredAt")
	private int lastCheckinExpiredAt;

	public boolean isMarked(){
		return marked;
	}

	public int getCount(){
		return count;
	}

	public int getUnconfirmedCount(){
		return unconfirmedCount;
	}

	public int getLastCheckinExpiredAt(){
		return lastCheckinExpiredAt;
	}
}