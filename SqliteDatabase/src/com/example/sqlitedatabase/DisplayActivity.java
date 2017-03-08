package com.example.sqlitedatabase;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayActivity extends Activity {

	ListView lView;
	SQLiteDatabase sqLiteDatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		
		ArrayList<String> al = new ArrayList<String>();
		lView = (ListView)findViewById(R.id.listView1);
		
        sqLiteDatabase = openOrCreateDatabase("Info", MODE_PRIVATE, null);
        
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Contact_info", null);
        if(cursor!=null){
        	cursor.moveToFirst();
        	while (!cursor.isAfterLast()) {
				al.add(cursor.getString(0)+" "+cursor.getString(1));
				
				cursor.moveToNext();
			}
        	
        }
        else{
        	al.add("Record not found");
        }
        cursor.close();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
    	lView.setAdapter(aa);

	}

}
