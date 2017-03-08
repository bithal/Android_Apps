package com.example.locationservice;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1;
	double lat=0,lon=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1 = (Button)findViewById(R.id.button1);
        
        btn1.setOnClickListener(this);
        
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new Location());
        
    }
	@Override
	public void onClick(View arg0) {

		Toast.makeText(this, "Latitude : "+String.valueOf(lat)+"\nLongitude : "+String.valueOf(lon), Toast.LENGTH_SHORT).show();
		
		String loc = lat+","+lon;
		String data = null;
		if (lat !=0.0 && lon !=0.0) {
			
			RetriveLocation retriveLocation = new RetriveLocation(loc);
			try {
				retriveLocation.thread.join();
				data = retriveLocation.data;
				Toast.makeText(this, data, Toast.LENGTH_LONG).show();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public class Location implements LocationListener {

		@Override
		public void onLocationChanged(android.location.Location location) {
			lat = location.getLatitude();
			lon = location.getLongitude();
		}

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
