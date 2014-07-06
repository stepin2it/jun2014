package com.example.flickrphotoapp;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Photos {
	
	@SerializedName("page")
    private String page;
    
    @SerializedName("pages")
    private String pages;
    
    @SerializedName("total")
    private int total;
    
    @SerializedName("photo")
    private List<Photo> photos;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	/**
     * @return the photosList
     */
    public List<Photo> getFlickrPhotoList()
    {
        return photos;
    }

    /**
     * @param photosList the photosList to set
     */
    public void setPhotoList(List<Photo> photosList)
    {
        this.photos = photosList;
    }
	
	public Photos() {
		// TODO Auto-generated constructor stub
	}

}
