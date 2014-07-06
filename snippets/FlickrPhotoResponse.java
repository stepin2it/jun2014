package com.example.flickrphotoapp;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class FlickrPhotoResponse
{
	@SerializedName("stat")
	private String stat;

	@SerializedName("photos")
	private Photos photos;

	@SerializedName("message")
	private String message;

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * @return the stat
	 */
	public String getStat()
	{
		return stat;
	}

	/**
	 * @param stat
	 *            the stat to set
	 */
	public void setStat(String stat)
	{
		this.stat = stat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	public Photos getPhotos()
	{
		return photos;
	}

	public void setPhotos(Photos photos)
	{
		this.photos = photos;
	}

	@Override
	public String toString()
	{
		return "FlickrPhotoResponse [photoList=" + photos + ", stat=" + stat
				+ "]";
	}

}
