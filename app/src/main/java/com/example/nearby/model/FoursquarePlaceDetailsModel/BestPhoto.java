package com.example.nearby.model.FoursquarePlaceDetailsModel;

import com.google.gson.annotations.SerializedName;

public class BestPhoto{

	@SerializedName("createdAt")
	private int createdAt;

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

	@SerializedName("height")
	private int height;

	public int getCreatedAt(){
		return createdAt;
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

	public int getHeight(){
		return height;
	}
}