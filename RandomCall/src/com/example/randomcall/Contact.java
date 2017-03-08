package com.example.randomcall;

import java.util.ArrayList;
import java.util.Random;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.Toast;

public class Contact extends BroadcastReceiver{

	ArrayList<String> numbersList = new ArrayList<String>();
	@Override
	public void onReceive(Context context, Intent intent) {
	
		Toast.makeText(context, "Outgoing Call Are Random", Toast.LENGTH_SHORT).show();
		
		Cursor phones = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
		 while (phones.moveToNext()){
		        
//	         String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
			 String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//	         Toast.makeText(getApplicationContext(),name+"\n"+phoneNumber, Toast.LENGTH_SHORT).show();
			 numbersList.add(phoneNumber);
		 }	
		 phones.close();
		 
		 Random random = new Random();
         Toast.makeText(context,numbersList.get(random.nextInt(numbersList.size())) , Toast.LENGTH_SHORT).show();
         String currNumber = intent.getStringExtra(intent.EXTRA_PHONE_NUMBER);
		 numbersList.remove(currNumber);
		 setResultData(numbersList.get(random.nextInt(numbersList.size())));
	   
	}

}
