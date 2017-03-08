package com.example.incomingcall_broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class IncomingCall extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
		
		if (state.equals("RINGING")) {
			Toast.makeText(context, "Ringing", Toast.LENGTH_SHORT).show();
		}
		if (state.equals("OFFHOOK")) {
			Toast.makeText(context, "Offhook", Toast.LENGTH_SHORT).show();
		}
		if (state.equals("IDLE")) {
			Toast.makeText(context, "Idle", Toast.LENGTH_SHORT).show();
		}
	}

}
