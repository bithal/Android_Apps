package com.example.incomingcall_message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
//import android.telephony.gsm.SmsManager;
import android.widget.Toast;

public class BroadcastReciver_Message extends BroadcastReceiver{

	static int Ringing = 0;
	static int Offhook = 0;
	static int Idle = 0;
	SharedPreferences sp;
	Context c;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
		String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
		c=context;
        sp = context.getSharedPreferences("Message", 0);
        
		Toast.makeText(context, number, Toast.LENGTH_SHORT).show();

        if (state.equals("RINGING")) {
			Ringing = 1;
			Toast.makeText(context, "Ringing", Toast.LENGTH_SHORT).show();
		}
		if (state.equals("OFFHOOK")) {
			Offhook = 1;
			Toast.makeText(context, "Offhook", Toast.LENGTH_SHORT).show();
		}
		if (state.equals("IDLE")) {
			Idle = 1;
			Toast.makeText(context, "Idle", Toast.LENGTH_SHORT).show();
		}
		if(Ringing == 1 && Idle == 1){
			Toast.makeText(context, "Missed call from "+number, Toast.LENGTH_SHORT).show();

			Send_Message(number);
		}
		
	}
	
	public void Send_Message(String number) {
			SQLiteDatabase db = c.openOrCreateDatabase("Test",0, null);;
			String message = null;
			Cursor cursor =new DBHandler(db).Select();
			if(cursor!=null)
	        {
	        	cursor.moveToFirst();
	        	while (!cursor.isAfterLast())
	        	{
	        		message = cursor.getString(1);
	        		cursor.moveToNext();
				}
	        	try {
	        		SmsManager smsManager = SmsManager.getDefault();
					
					smsManager.sendTextMessage(number, null, message, null, null);
					Toast.makeText(c, message+" "+number, Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					Toast.makeText(c, e+"", Toast.LENGTH_SHORT).show();

				}
	        	
	        }
	        else
	        {
				Toast.makeText(c, "No message send!", Toast.LENGTH_SHORT).show();
	        }
	}
}
