package com.example.nearby.model.FoursquareModel;


import com.google.gson.annotations.SerializedName;

public class CategoriesItem{

	@SerializedName("pluralName")
	private String pluralName;

	@SerializedName("name")
	private String name;

	@SerializedName("icon")
	private Icon icon;

	@SerializedName("id")
	private String id;

	@SerializedName("shortName")
	private String shortName;

	@SerializedName("primary")
	private boolean primary;

	public String getPluralName(){
		return pluralName;
	}

	public String getName(){
		return name;
	}

	public Icon getIcon(){
		return icon;
	}

	public String getId(){
		return id;
	}

	public String getShortName(){
		return shortName;
	}

	public boolean isPrimary(){
		return primary;
	}
}