package com.stepin2it.mycuisineapp;
import com.stepin2it.mycuisineapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity{
	// declare TextView property
	private TextView textView1;
	private Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// initialize the textView1 object
		textView1 = (TextView)findViewById(R.id.textView1);
		button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,  OrderingMenu.class);
				startActivity(intent);
			}
		});

	}
	
}
