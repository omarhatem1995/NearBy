package com.example.nearby.model.FoursquareModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("cc")
	private String cc;

	@SerializedName("country")
	private String country;

	@SerializedName("address")
	private String address;

	@SerializedName("labeledLatLngs")
	private List<LabeledLatLngsItem> labeledLatLngs;

	@SerializedName("lng")
	private double lng;

	@SerializedName("distance")
	private int distance;

	@SerializedName("formattedAddress")
	private List<String> formattedAddress;

	@SerializedName("city")
	private String city;

	@SerializedName("postalCode")
	private String postalCode;

	@SerializedName("state")
	private String state;

	@SerializedName("lat")
	private double lat;

	@SerializedName("crossStreet")
	private String crossStreet;

	@SerializedName("neighborhood")
	private String neighborhood;

	public String getCc(){
		return cc;
	}

	public String getCountry(){
		return country;
	}

	public String getAddress(){
		return address;
	}

	public List<LabeledLatLngsItem> getLabeledLatLngs(){
		return labeledLatLngs;
	}

	public double getLng(){
		return lng;
	}

	public int getDistance(){
		return distance;
	}

	public List<String> getFormattedAddress(){
		return formattedAddress;
	}

	public String getCity(){
		return city;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public String getState(){
		return state;
	}

	public double getLat(){
		return lat;
	}

	public String getCrossStreet(){
		return crossStreet;
	}

	public String getNeighborhood(){
		return neighborhood;
	}
}