package com.stepin2it.mycuisineapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PhotoDetailActivity extends Activity {
	private TextView mTextView2;
	
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_photodetail);
			mTextView2 = (TextView) findViewById(R.id.textView2);
			int position = this.getIntent().getIntExtra("row_photo", 0);
			mTextView2.setText("Position clicked : " + position);
		}
}
