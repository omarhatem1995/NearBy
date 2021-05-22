package com.example.nearby.model.FoursquarePlaceDetailsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Tips{

	@SerializedName("count")
	private int count;

	@SerializedName("groups")
	private List<Object> groups;

	public int getCount(){
		return count;
	}

	public List<Object> getGroups(){
		return groups;
	}
}