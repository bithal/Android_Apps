package com.example.returndata;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Second extends Activity {

	int res;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Bundle bundle = getIntent().getExtras();
		
		int n1 = Integer.parseInt(bundle.getString("num1"));
		int n2 = Integer.parseInt(bundle.getString("num2"));
		
		res = n1+n2;
		finish();
		
	}
	
	@Override
	public void finish() {
		Intent intent =new Intent();
		
		intent.putExtra("sum", res+"");
		setResult(RESULT_OK,intent);
		super.finish();
	}


}
