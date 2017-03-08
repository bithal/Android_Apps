package com.example.passdata;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Second extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		TextView textView1 = (TextView)findViewById(R.id.textView1);
		TextView textView2 = (TextView)findViewById(R.id.textView2);
		
		Bundle bundle = getIntent().getExtras();
		String name = bundle.getString("name");
		String mob = bundle.getString("mob");
		
		textView1.setText("Name : "+name);
		textView2.setText("Mobile No : "+mob);
	}

	

}
