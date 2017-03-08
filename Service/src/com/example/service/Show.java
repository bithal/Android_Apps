package com.example.service;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Show extends Activity {

	GridView gView;
	ArrayList<String> aList;
	SQLiteDatabase sqlDb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		
		sqlDb = openOrCreateDatabase("location", MODE_PRIVATE, null);

		gView = (GridView)findViewById(R.id.gridView1);
		aList = new ArrayList<String>();
		
		 Cursor cursor = sqlDb.rawQuery("SELECT DATE,TIME,LATITUDE,LONGITUDE FROM Location_Info", null);
	        if(cursor!=null)
	        {
	        	cursor.moveToFirst();
	        	while (!cursor.isAfterLast())
	        	{
	        		aList.add(cursor.getString(0)+"\n"+cursor.getString(1));
	        		aList.add(cursor.getString(2));
					aList.add(cursor.getString(3));
					cursor.moveToNext();
				}
	        }
	        else
	        {
	        	aList.add("Record not found");
	        }
	        cursor.close();
	        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,aList);
	    	gView.setAdapter(aa);
		
	}

}
