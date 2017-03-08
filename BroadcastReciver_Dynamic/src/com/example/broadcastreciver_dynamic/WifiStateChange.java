package com.example.broadcastreciver_dynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class WifiStateChange extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
Toast.makeText(arg0, "Wifi state changed", Toast.LENGTH_SHORT).show();		
	}

}
