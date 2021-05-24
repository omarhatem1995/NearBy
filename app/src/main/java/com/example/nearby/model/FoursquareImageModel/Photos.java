package com.example.nearby.model.FoursquareImageModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Photos{

	@SerializedName("count")
	private int count;

	@SerializedName("items")
	private List<ItemsItem> items;

	public int getCount(){
		return count;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}