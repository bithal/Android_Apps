package com.example.contact_app;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class CViewContactActivity extends Activity implements OnItemClickListener,OnClickListener {


	ListView lView;
	EditText et1;
	Button btn1;
	SQLiteDatabase sqLiteDatabase;
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> id = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cview_contact);
		
		
		lView = (ListView)findViewById(R.id.listView1);
		btn1 = (Button)findViewById(R.id.button1);
		et1 = (EditText)findViewById(R.id.editText1);
		
		btn1.setOnClickListener(this);
		lView.setOnItemClickListener(this);
		
        sqLiteDatabase = openOrCreateDatabase("Contact", MODE_PRIVATE, null);
        
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT NAME,ID FROM ContactInfo ORDER BY NAME ASC", null);
        if(cursor!=null)
        {
        	cursor.moveToFirst();
        	while (!cursor.isAfterLast())
        	{
				al.add(cursor.getString(0));
				id.add(cursor.getString(1));
				cursor.moveToNext();
			}
        }
        else
        {
        	al.add("Record not found");
        }
        cursor.close();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
    	lView.setAdapter(aa);

	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		String Id = id.get(pos);
		al.clear();
		id.clear();
		Intent intent = new Intent(this,UpdateActivity.class);
		intent.putExtra("Id", Id);
		startActivity(intent);
	}
	public void search(View view) {
		
		
	}
	@Override
	public void onClick(View arg0) {
		String pattern = et1.getText().toString();
		Cursor cursor = sqLiteDatabase.rawQuery("SELECT NAME,ID FROM ContactInfo WHERE NAME LIKE '"+pattern+"%' ORDER BY NAME ASC", null);
        if(cursor!=null)
        {
        	al.clear();
    		id.clear();
        	cursor.moveToFirst();
        	while (!cursor.isAfterLast())
        	{
				al.add(cursor.getString(0));
				id.add(cursor.getString(1));
				cursor.moveToNext();
			}
        }
        else
        {
        	al.add("Record not found");
        }
        cursor.close();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
    	lView.setAdapter(aa);
	}
	
}
