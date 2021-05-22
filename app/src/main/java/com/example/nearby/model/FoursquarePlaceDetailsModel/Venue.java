package com.example.nearby.model.FoursquarePlaceDetailsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Venue{

	@SerializedName("parent")
	private Parent parent;

	@SerializedName("reasons")
	private Reasons reasons;

	@SerializedName("specials")
	private Specials specials;

	@SerializedName("dislike")
	private boolean dislike;

	@SerializedName("shortUrl")
	private String shortUrl;

	@SerializedName("photos")
	private Photos photos;

	@SerializedName("tips")
	private Tips tips;

	@SerializedName("colors")
	private Colors colors;

	@SerializedName("hereNow")
	private HereNow hereNow;

	@SerializedName("createdAt")
	private int createdAt;

	@SerializedName("stats")
	private Stats stats;

	@SerializedName("seasonalHours")
	private List<Object> seasonalHours;

	@SerializedName("contact")
	private Contact contact;

	@SerializedName("id")
	private String id;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	@SerializedName("ok")
	private boolean ok;

	@SerializedName("likes")
	private Likes likes;

	@SerializedName("canonicalUrl")
	private String canonicalUrl;

	@SerializedName("hierarchy")
	private List<HierarchyItem> hierarchy;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("timeZone")
	private String timeZone;

	@SerializedName("beenHere")
	private BeenHere beenHere;

	@SerializedName("bestPhoto")
	private BestPhoto bestPhoto;

	@SerializedName("listed")
	private Listed listed;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Location location;

	@SerializedName("attributes")
	private Attributes attributes;

	@SerializedName("pageUpdates")
	private PageUpdates pageUpdates;

	@SerializedName("inbox")
	private Inbox inbox;

	public Parent getParent(){
		return parent;
	}

	public Reasons getReasons(){
		return reasons;
	}

	public Specials getSpecials(){
		return specials;
	}

	public boolean isDislike(){
		return dislike;
	}

	public String getShortUrl(){
		return shortUrl;
	}

	public Photos getPhotos(){
		return photos;
	}

	public Tips getTips(){
		return tips;
	}

	public Colors getColors(){
		return colors;
	}

	public HereNow getHereNow(){
		return hereNow;
	}

	public int getCreatedAt(){
		return createdAt;
	}

	public Stats getStats(){
		return stats;
	}

	public List<Object> getSeasonalHours(){
		return seasonalHours;
	}

	public Contact getContact(){
		return contact;
	}

	public String getId(){
		return id;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public boolean isOk(){
		return ok;
	}

	public Likes getLikes(){
		return likes;
	}

	public String getCanonicalUrl(){
		return canonicalUrl;
	}

	public List<HierarchyItem> getHierarchy(){
		return hierarchy;
	}

	public boolean isVerified(){
		return verified;
	}

	public String getTimeZone(){
		return timeZone;
	}

	public BeenHere getBeenHere(){
		return beenHere;
	}

	public BestPhoto getBestPhoto(){
		return bestPhoto;
	}

	public Listed getListed(){
		return listed;
	}

	public String getName(){
		return name;
	}

	public Location getLocation(){
		return location;
	}

	public Attributes getAttributes(){
		return attributes;
	}

	public PageUpdates getPageUpdates(){
		return pageUpdates;
	}

	public Inbox getInbox(){
		return inbox;
	}
}