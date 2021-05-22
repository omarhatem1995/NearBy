package com.example.nearby.model.FoursquarePlaceDetailsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Listed{

	@SerializedName("count")
	private int count;

	@SerializedName("groups")
	private List<GroupsItem> groups;

	public int getCount(){
		return count;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}
}