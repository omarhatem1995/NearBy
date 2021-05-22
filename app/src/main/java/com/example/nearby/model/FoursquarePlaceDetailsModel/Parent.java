package com.example.nearby.model.FoursquarePlaceDetailsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Parent{

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private String id;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	public String getName(){
		return name;
	}

	public Location getLocation(){
		return location;
	}

	public String getId(){
		return id;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}
}