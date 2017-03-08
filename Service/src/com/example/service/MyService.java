package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Service;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class MyService extends Service {

	LocationManager locationManager;
	LocationListener locationListener;
	SQLiteDatabase sqlDb;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	 @Override
	   public int onStartCommand(Intent intent, int flags, int startId) {
	      // Let it continue running until it is stopped.
	      Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
	      return START_STICKY;
	   }
	 
	 @Override
	public void onCreate() {
		 sqlDb = openOrCreateDatabase("location", MODE_PRIVATE, null);
		 sqlDb.execSQL("CREATE TABLE IF NOT EXISTS Location_Info (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,TIME TEXT,LATITUDE TEXT,LONGITUDE TEXT)");
		 
		 locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
		 locationListener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String arg0) {
				Intent in = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(in);				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				double lat = location.getLatitude();
                double lon = location.getLongitude();		
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                String Date = sdf.format(new Date());

                SimpleDateFormat stf = new SimpleDateFormat("HH.mm.ss");
                String Time = stf.format(new Date());
                
                sqlDb.execSQL("INSERT INTO Location_Info (DATE,TIME,LATITUDE,LONGITUDE) VALUES('"+Date+"','"+Time+"','"+lat+"','"+lon+"')");
			}
		};
		configureButton();
		super.onCreate();
	}
	 private void configureButton() {
	        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 600000, 0, locationListener);
	    }
	 @Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		 
		 configureButton();
		 
		 super.onStart(intent, startId);
	}
	
	 
	 @Override
	   public void onDestroy() {
	      super.onDestroy();
	      Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	   }

}
