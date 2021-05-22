package com.example.nearby.model.FoursquarePlaceDetailsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GroupsItem{

	@SerializedName("summary")
	private String summary;

	@SerializedName("name")
	private String name;

	@SerializedName("count")
	private int count;

	@SerializedName("type")
	private String type;

	@SerializedName("items")
	private List<ItemsItem> items;

	public String getSummary(){
		return summary;
	}

	public String getName(){
		return name;
	}

	public int getCount(){
		return count;
	}

	public String getType(){
		return type;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}