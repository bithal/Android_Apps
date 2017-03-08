package com.example.service;

import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1,btn2,btn3,btn4,btn5;
	SQLiteDatabase sqlDb;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		sqlDb = openOrCreateDatabase("location", MODE_PRIVATE, null);

        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

	@Override
	public void onClick(View view) {
		if (view.getId()==R.id.button1){
			Intent intent = new Intent(this, MyService.class);
			startService(intent);
		}
		else if (view.getId()==R.id.button2){
			Intent intent = new Intent(this, MyService.class);
			stopService(intent);
		}
		else if (view.getId()==R.id.button3){
			Intent intent = new Intent(this, Show.class);
			startActivity(intent);
			}
		else if(view.getId()==R.id.button4){
			sqlDb.delete("Location_Info", null, null);

		}
		else {
			Cursor cursor = sqlDb.rawQuery("SELECT DATE,TIME,LATITUDE,LONGITUDE FROM Location_Info", null);
			String locData[] = new String[5]; 
	        if(cursor!=null)
	        {
	        	cursor.moveToFirst();
	        	while (!cursor.isAfterLast())
	        	{
	        		locData[0] = cursor.getString(1);
	        		locData[1] = cursor.getString(1);
	        		locData[2] = cursor.getString(1);
	        		locData[3] = cursor.getString(1);
	        		locData[4] = cursor.getString(1);
	        		try {
						URL url = new URL
						("http://192.168.1.66:9090/LocationApp_Server?id="+locData[0]+"&date="+locData[1]+"&time="+locData[2]+"&latitude="+locData[3]+"&longitude="+locData[4]);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					cursor.moveToNext();
				}
	        }
		}
	}
    
}
