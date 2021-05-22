package com.example.nearby.model.FoursquareImageModel;

import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("createdAt")
	private int createdAt;

	@SerializedName("checkin")
	private Checkin checkin;

	@SerializedName("visibility")
	private String visibility;

	@SerializedName("prefix")
	private String prefix;

	@SerializedName("width")
	private int width;

	@SerializedName("id")
	private String id;

	@SerializedName("source")
	private Source source;

	@SerializedName("suffix")
	private String suffix;

	@SerializedName("user")
	private User user;

	@SerializedName("height")
	private int height;

	public int getCreatedAt(){
		return createdAt;
	}

	public Checkin getCheckin(){
		return checkin;
	}

	public String getVisibility(){
		return visibility;
	}

	public String getPrefix(){
		return prefix;
	}

	public int getWidth(){
		return width;
	}

	public String getId(){
		return id;
	}

	public Source getSource(){
		return source;
	}

	public String getSuffix(){
		return suffix;
	}

	public User getUser(){
		return user;
	}

	public int getHeight(){
		return height;
	}
}