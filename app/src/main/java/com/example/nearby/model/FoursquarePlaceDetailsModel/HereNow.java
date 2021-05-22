package com.example.nearby.model.FoursquarePlaceDetailsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HereNow{

	@SerializedName("summary")
	private String summary;

	@SerializedName("count")
	private int count;

	@SerializedName("groups")
	private List<Object> groups;

	public String getSummary(){
		return summary;
	}

	public int getCount(){
		return count;
	}

	public List<Object> getGroups(){
		return groups;
	}
}