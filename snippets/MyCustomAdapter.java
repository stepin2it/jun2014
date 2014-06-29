public class MyCustomAdapter extends ArrayAdapter<Photo>
	{
		public MyCustomAdapter(Context context, int textViewResourceId,	List<Photo> mListOfPhotos)
		{
			super(context, textViewResourceId, mListOfPhotos);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			// TODO Auto-generated method stub
			
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
					Log.d(TAG, "-------------------" + rownumber);
					Log.d(TAG, "---id of photo :----------------" + mListOfPhotos.get(rownumber).getId());					
					
					 Intent intent = new Intent(PhotosListActivity.this, PhotoViewActivity.class);
					 intent.putExtra("FLAG", 1);
					 intent.putExtra("PHOTO_ID", mListOfPhotos.get(rownumber).getId());
					 intent.putExtra("PHOTO_BITMAP", mPhotoBitmap.get(rownumber));
					 //intent.putExtra("HASH_MAP", mMap);
					 int requestCode = 0;
					 //startActivityForResult(intent, requestCode);
					 startActivity(intent);
				}
				
			});

			TextView list_name = (TextView) row.findViewById(R.id.list_name);

			TextView list_tagline = (TextView) row
					.findViewById(R.id.list_tagline);

			list_name.setText(mListOfPhotos.get(position).getTitle());

			list_tagline.setText(mListOfPhotos.get(position).getDescription().getContent());
			
			int i = 0;
//			for(Photo p : mMap.keySet()){
//				Log.d(TAG, "--------------- HashMap Photo reference is = "+p.toString());
//				Log.d(TAG, "--------------- Actual Photo reference is = "+mListOfPhotos.get(i++).toString());
//			}		

			imageView1 = (ImageView) row.findViewById(R.id.imageView1);
			imageView1.setImageResource(R.drawable.ic_launcher);
			
			if(mPhotoBitmap.get(position) != null){
				if(mPhotoBitmap.get(position) != null){
					imageView1.setImageBitmap(mPhotoBitmap.get(position));
				}
				else{
					Log.d(TAG, "Bitmap returned NULL");
				}
			}
			
			return row;
			

		}
	}
