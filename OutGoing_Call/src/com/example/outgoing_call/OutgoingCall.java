package com.example.outgoing_call;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OutgoingCall extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Outgoing Call Blocked", Toast.LENGTH_LONG).show();
//		setResultData(null);//block all outgoing calls
		setResultData("9937710117");//outgoing call to only 1234567890 number
		
	}

}
