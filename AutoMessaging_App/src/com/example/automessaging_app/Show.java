package com.example.automessaging_app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Show extends Activity implements OnItemClickListener{

	ListView lView;
	ArrayList<String> aList,id;
	SQLiteDatabase db;
	DBHandler dbHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		
		db = openOrCreateDatabase("Test", MODE_PRIVATE, null);
		
		lView = (ListView)findViewById(R.id.listView1);
		lView.setOnItemClickListener(this);
		aList = new ArrayList<String>();
		id = new ArrayList<String>();
		
		Cursor cursor = new DBHandler(db).Select();
		
		if (cursor!=null) {
			cursor.moveToFirst();
			while(!cursor.isAfterLast()){
				aList.add(cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3));
				id.add(cursor.getString(0));
				cursor.moveToNext();
			}
		}
		else {
			aList.add("No record found");
		}
		cursor.close();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,aList);
		lView.setAdapter(adapter);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		Intent intent = new Intent(this,Edit.class);
		intent.putExtra("id", id.get(pos));
		startActivity(intent);
	}

}
