package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class HierarchyItem{

	@SerializedName("canonicalUrl")
	private String canonicalUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("lang")
	private String lang;

	public String getCanonicalUrl(){
		return canonicalUrl;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getLang(){
		return lang;
	}
}