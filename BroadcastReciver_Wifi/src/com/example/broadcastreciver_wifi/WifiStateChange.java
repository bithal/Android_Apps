package com.example.broadcastreciver_wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class WifiStateChange extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		Toast.makeText(context, "Wifi State changed", Toast.LENGTH_SHORT).show();
		
	}

}
