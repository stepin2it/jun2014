package com.stepin2it.mycuisineapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OrderingMenu extends Activity{

	
	private static final String TAG = "OrderingMenu";
	public List<Photo> mListOfPhotos = new ArrayList<Photo>();
	public List<Photo> mPhotoBitmap = new ArrayList<Photo>();
	private ListView mListView;


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

			list_tagline.setText(mListOfPhotos.get(position).getDescription());
			
			int i = 0;
//			for(Photo p : mMap.keySet()){
//				Log.d(TAG, "--------------- HashMap Photo reference is = "+p.toString());
//				Log.d(TAG, "--------------- Actual Photo reference is = "+mListOfPhotos.get(i++).toString());
//			}		

			ImageView imageView1 = (ImageView) row.findViewById(R.id.imageView1);
			imageView1.setImageResource(R.drawable.ic_launcher);
			
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
		Photo p = new Photo();
		p.setTitle("Photo of Salad");
		p = new Photo();
		p.setTitle("Photo of Dessert");
		
		mListOfPhotos.add(p);
		
		MyCustomAdapter adapter = new MyCustomAdapter(this, 0, mListOfPhotos);
		mListView.setAdapter(adapter);
	}
	
}
