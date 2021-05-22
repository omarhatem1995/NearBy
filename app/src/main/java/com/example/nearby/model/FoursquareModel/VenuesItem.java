package com.example.nearby.model.FoursquareModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class VenuesItem{

	@SerializedName("hasPerk")
	private boolean hasPerk;

	@SerializedName("referralId")
	private String referralId;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private String id;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	@SerializedName("delivery")
	private Delivery delivery;

	@SerializedName("venuePage")
	private VenuePage venuePage;

	public void setHasPerk(boolean hasPerk) {
		this.hasPerk = hasPerk;
	}

	public void setReferralId(String referralId) {
		this.referralId = referralId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCategories(List<CategoriesItem> categories) {
		this.categories = categories;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void setVenuePage(VenuePage venuePage) {
		this.venuePage = venuePage;
	}

	public boolean isHasPerk(){
		return hasPerk;
	}

	public String getReferralId(){
		return referralId;
	}

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

	public Delivery getDelivery(){
		return delivery;
	}

	public VenuePage getVenuePage(){
		return venuePage;
	}
}