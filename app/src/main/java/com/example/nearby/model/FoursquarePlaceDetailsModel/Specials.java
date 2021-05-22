package com.example.nearby.model.FoursquarePlaceDetailsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Specials{

	@SerializedName("count")
	private int count;

	@SerializedName("items")
	private List<Object> items;

	public int getCount(){
		return count;
	}

	public List<Object> getItems(){
		return items;
	}
}