package com.example.automessaging_app;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class IncommingSMS extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		SQLiteDatabase db = context.openOrCreateDatabase("Test", 0, null);
		DBHandler dbHandler = new DBHandler(db);
		if (bundle!=null) {
			Object[] pdusObjects = (Object[]) bundle.get("pdus");
			for (int i=0; i<pdusObjects.length; i++){
				
				SmsMessage currentMessage = SmsMessage.createFromPdu((byte[])pdusObjects[i]);
				String number = currentMessage.getDisplayOriginatingAddress();
				String message = currentMessage.getDisplayMessageBody();
				
				Toast.makeText(context, number+"\n"+message, Toast.LENGTH_SHORT).show();
			
				try {
					String out_sms = dbHandler.Select_Sms(number.substring(3), message);
					Toast.makeText(context, number+"\n"+message+"\n"+out_sms, Toast.LENGTH_LONG).show();
					
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(number, null, out_sms, null, null);
					
				} catch (Exception e) {
					Toast.makeText(context, e+"", Toast.LENGTH_LONG).show();
				}

				
			}
		}
	}

}
