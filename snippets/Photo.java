package com.example.flickrphotoapp;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Photo implements Serializable
{
	public static enum PhotoSize {
		s,	// small square 75x75
		q,	// large square 150x150
		t,	// thumbnail, 100 on longest side
		m,	// small, 240 on longest side
		n,	// small, 320 on longest side
		z,	// medium 640, 640 on longest side
		c,	// medium 800, 800 on longest side
		b,	// large, 1024 on longest side
		o	//original image, either a jpg, gif or png, depending on source format
	}
	
	@SerializedName("id")
	private long id;
	@SerializedName("owner")
	private String owner;
	@SerializedName("secret")
	private String secret;
	@SerializedName("server")
	private int server;
	@SerializedName("farm")
	private int farm;
	@SerializedName("title")
	private String title;
	@SerializedName("ispublic")
	private int ispublic;
	@SerializedName("isfriend")
	private int isfriend;
	@SerializedName("isfamily")
	private int isfamily;
	@SerializedName("originalsecret")
	private String originalsecret;
	@SerializedName("originalformat")
	private String originalformat;
	@SerializedName("tags")
	private String tags;
	@SerializedName("latitude")
	private double latitude;
	@SerializedName("longitude")
	private double longitude;
	@SerializedName("accuracy")
	private int accuracy;
	@SerializedName("context")
	private int context;
	@SerializedName("place_id")
	private String place_id;
	@SerializedName("woeid")
	private String woeid;
	@SerializedName("geo_is_family")
	private int geo_is_family;
	@SerializedName("geo_is_friend")
	private int geo_is_friend;
	@SerializedName("geo_is_contact")
	private int geo_is_contact;
	@SerializedName("geo_is_public")
	private int geo_is_public;
	@SerializedName("dateupload")
	private String dateupload;
	@SerializedName("ownername")
	private String ownername;
	@SerializedName("description")
	private Description description;
	
	class Description implements Serializable{
		@SerializedName("_content")
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public int getFarm() {
		return farm;
	}
	public void setFarm(int farm) {
		this.farm = farm;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIspublic() {
		return ispublic;
	}
	public void setIspublic(int ispublic) {
		this.ispublic = ispublic;
	}
	public int getIsfriend() {
		return isfriend;
	}
	public void setIsfriend(int isfriend) {
		this.isfriend = isfriend;
	}
	public int getIsfamily() {
		return isfamily;
	}
	public void setIsfamily(int isfamily) {
		this.isfamily = isfamily;
	}
	public String getOriginalsecret() {
		return originalsecret;
	}
	public void setOriginalsecret(String originalsecret) {
		this.originalsecret = originalsecret;
	}
	public String getOriginalformat() {
		return originalformat;
	}
	public void setOriginalformat(String originalformat) {
		this.originalformat = originalformat;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public int getContext() {
		return context;
	}
	public void setContext(int context) {
		this.context = context;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getWoeid() {
		return woeid;
	}
	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}
	public int getGeo_is_family() {
		return geo_is_family;
	}
	public void setGeo_is_family(int geo_is_family) {
		this.geo_is_family = geo_is_family;
	}
	public int getGeo_is_friend() {
		return geo_is_friend;
	}
	public void setGeo_is_friend(int geo_is_friend) {
		this.geo_is_friend = geo_is_friend;
	}
	public int getGeo_is_contact() {
		return geo_is_contact;
	}
	public void setGeo_is_contact(int geo_is_contact) {
		this.geo_is_contact = geo_is_contact;
	}
	public int getGeo_is_public() {
		return geo_is_public;
	}
	public void setGeo_is_public(int geo_is_public) {
		this.geo_is_public = geo_is_public;
	}
	public String getDateupload() {
		return dateupload;
	}
	public void setDateupload(String dateupload) {
		this.dateupload = dateupload;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	
	public String getPhotoURL(){
		// Format:
		// http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.(jpg|gif|png)		
		String photoURL = "http://farm"+this.getFarm()+".staticflickr.com/"+this.getServer()+"/"+this.getId()+"_"+this.getSecret()+"."+this.getOriginalformat();
		return photoURL;
	}
	
	public String getPhotoURL(PhotoSize size){
		// Format:
		// http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.(jpg|gif|png)
		String sizeFlag = new String();
		switch(size){
		case s:
			sizeFlag = "_s";
			break;
		case b:
			sizeFlag = "_b";
			break;
		case c:
			sizeFlag = "_c";
			break;
		case m:
			sizeFlag = "_m";
			break;
		case n:
			sizeFlag = "_n";
			break;
		case o:
			sizeFlag = "_o";
			break;
		case q:
			sizeFlag = "_q";
			break;
		case t:
			sizeFlag = "_t";
			break;
		case z:
			sizeFlag = "_z";
			break;
		default:
			sizeFlag = "";
			break;
		}
		
		String photoURL = "http://farm"+this.getFarm()+".staticflickr.com/"+this.getServer()+"/"+this.getId()+"_"+this.getSecret()+sizeFlag+"."+this.getOriginalformat();
		return photoURL;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}

}
