package com.example.nearby.model.FoursquareImageModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Photos{

	@SerializedName("count")
	private int count;

	@SerializedName("dupesRemoved")
	private int dupesRemoved;

	@SerializedName("items")
	private List<ItemsItem> items;

	public int getCount(){
		return count;
	}

	public int getDupesRemoved(){
		return dupesRemoved;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}