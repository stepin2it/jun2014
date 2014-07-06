package com.example.flickrphotoapp;
public class FeaturesConfiguration
{
	
//    private static final String 
//    flickrURL = "http://api.flickr.com/services/rest/?user_id=48247111@N07&" 
//    +"format=json&nojsoncallback=1&extras=original_format,tags,description,geo," +
//    "date_upload,owner_name&page=1&method=flickr.photos.search&api_key=07a9a5938d3fa6c7f180fb0cb003327a";
    
    private static final String flickrURL = "http://api.flickr.com/services/rest/?user_id=48247111@N07&format=json&nojsoncallback=1&extras=original_format,tags,description,geo,date_upload,owner_name&page=1&method=flickr.photos.search&api_key=07a9a5938d3fa6c7f180fb0cb003327a";
    
    private static final String 
    flickrFavoriteURL = "http://api.flickr.com/services/rest/?user_id=48247111@N07&format=json&nojsoncallback=1&extras=original_format,tags,description,geo,date_upload,owner_name&page=1&method=flickr.favorites.getPublicList&api_key=07a9a5938d3fa6c7f180fb0cb003327a";

    /**
     * @return the flickrurl
     */
    public static String getFlickrurl()
    {
        return flickrURL;
    }
    
    
}


