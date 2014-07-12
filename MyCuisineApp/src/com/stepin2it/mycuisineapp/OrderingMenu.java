package com.stepin2it.mycuisineapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.stepin2it.mycuisineapp.Photo.PhotoSize;
import com.stepin2it.mycuisineapp.utils.ImageCacheLoader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class OrderingMenu extends Activity{

	
	private static final String TAG = "OrderingMenu";
	public List<Photo> mListOfPhotos = new ArrayList<Photo>();
	public HashMap<Integer, String> mPhotosMap = new HashMap<Integer, String>();
	public List<Photo> mPhotoBitmap = new ArrayList<Photo>();
	private ListView mListView;
	private FlickrPhotoResponse mFlickrPhotoResponse;
	private ProgressDialog mProgressBar;
	private ImageCacheLoader mImageCacheLoader;
	private class DataLoadingTask extends AsyncTask<Integer, Integer, Integer>
	{
		@Override
		protected void onPreExecute()
		{
			
		}

		@Override
		protected Integer doInBackground(Integer... arg0)
		{

			try
			{
				read();
			} catch (IOException e)
			{
				e.printStackTrace();
			}

			return null;

		}

		@Override
		protected void onProgressUpdate(Integer... values)
		{
			// Do nothing
		}

		@Override
		protected void onPostExecute(Integer result)
		{
			display();
		}

	}

	protected void read() throws IOException
	{
		String jsonFileUrl = FeaturesConfiguration.flickrFavoriteURL;
		mFlickrPhotoResponse = ObjectsReader.readFlickrPhotoResponse(jsonFileUrl);
		
		mListOfPhotos = mFlickrPhotoResponse.getPhotos().getFlickrPhotoList();
		
		int progress = 0;
		int progressIncrement = mProgressBar.getMax()/mListOfPhotos.size();
		
		if(mListOfPhotos != null){
			Log.d(FeaturesConfiguration.GLOBALTAG, mListOfPhotos.get(0).getTitle());
			Log.d(FeaturesConfiguration.GLOBALTAG, mListOfPhotos.get(0).getPhotoURL());
		}
		else
			Log.d(FeaturesConfiguration.GLOBALTAG, "Null probably");
		
		// Getting whole PhotoURL list and Generating BITMAPs for Thumbnails
		for(int i = 0 ; i < mListOfPhotos.size() ; i++){
			Log.d(FeaturesConfiguration.GLOBALTAG, mListOfPhotos.get(i).getPhotoURL());
			
			try{
				URL myFileUrl = new URL (mListOfPhotos.get(i).getPhotoURL(PhotoSize.t));
			    HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
			    conn.setDoInput(true);
			    conn.connect();
			    // mPhotoBitmap.add(BitmapFactory.decodeStream(conn.getInputStream()));
			    // mMap.put(mListOfPhotos.get(i), mPhotoBitmap.get(i));
			    
			    // Display Progress
			    progress += progressIncrement;
			    mProgressBar.setProgress(progress);
			}
			catch(MalformedURLException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void display()
	{
		MyCustomAdapter adapter = new MyCustomAdapter(this, R.layout.row_photos, mListOfPhotos);
		mListView.setAdapter(adapter);		
		mProgressBar.dismiss();
	}

	public class MyCustomAdapter extends ArrayAdapter<Photo>
	{
		
		public MyCustomAdapter(Context context, int textViewResourceId,	List<Photo> mListOfPhotos)
		{
			super(context, textViewResourceId, mListOfPhotos);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			// TODO Fix compile errors in this class
			
			final int rownumber = position;
			View row = convertView;

			if (row == null)
			{
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.row_photos, parent, false);
			}
			
			row.setOnClickListener(new View.OnClickListener()
			{
				
				@Override
				public void onClick(View v)
				{

				}
				
			});	

			TextView list_name = (TextView) row.findViewById(R.id.list_name);

			TextView list_tagline = (TextView) row
					.findViewById(R.id.list_tagline);

			list_name.setText(mListOfPhotos .get(position).getTitle());
			String content = "";
			try {
			content = content + mListOfPhotos.get(position).getDescription().getContent();
			}
			catch (Exception e) {
				Log.e(TAG, "error : " + e.toString());
			}
			Log.d(TAG, "content : " + content);
			// String content = mListOfPhotos.get(position).getTitle();
			list_tagline.setText(content);
			
			int i = 0;
//			for(Photo p : mMap.keySet()){
//				Log.d(TAG, "--------------- HashMap Photo reference is = "+p.toString());
//				Log.d(TAG, "--------------- Actual Photo reference is = "+mListOfPhotos.get(i++).toString());
//			}		

			ImageView imageView1 = (ImageView) row.findViewById(R.id.imageView1);
			
			
			// imageView1.setImageResource(R.drawable.ic_launcher);
			mImageCacheLoader.DisplayImage(mListOfPhotos.get(position).getPhotoURL(Photo.PhotoSize.t), imageView1);
//			if(mPhotoBitmap.get(position) != null){
//				if(mPhotoBitmap.get(position) != null){
//				}
//				else{
//					Log.d(TAG, "Bitmap returned NULL");
//				}
//			}
			
			return row;
			

		}
		
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orderingmenu);
		mListView = (ListView) findViewById(R.id.listView1);

		mImageCacheLoader = new ImageCacheLoader(this);
		
		
		MyCustomAdapter adapter = new MyCustomAdapter(this, 0, mListOfPhotos);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.d(TAG, "row was clicked : " + position);
				Intent intent = new Intent();
				intent.putExtra("row_position", position);
			}
		});
		String jsonFileUrl = "https://api.flickr.com/services/rest/?user_id=11746711@N08&format=json&nojsoncallback=1&extras=original_format,tags,description,geo,date_upload,owner_name&page=1&method=flickr.favorites.getPublicList&api_key=07a9a5938d3fa6c7f180fb0cb003327a";
		mProgressBar = new ProgressDialog(OrderingMenu.this);
	    mProgressBar.setCancelable(false);
	    mProgressBar.setMessage("Downloading Images...");
	    mProgressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	    mProgressBar.setProgress(0);
	    mProgressBar.setMax(100);
	    mProgressBar.show();
		new DataLoadingTask().execute();
	}
	
}
