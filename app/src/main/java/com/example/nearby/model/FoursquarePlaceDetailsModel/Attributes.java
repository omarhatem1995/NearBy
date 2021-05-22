package com.example.nearby.model.FoursquarePlaceDetailsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Attributes{

	@SerializedName("groups")
	private List<GroupsItem> groups;

	public List<GroupsItem> getGroups(){
		return groups;
	}
}