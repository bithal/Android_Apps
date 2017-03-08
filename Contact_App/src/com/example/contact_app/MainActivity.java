package com.example.contact_app;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1,btn2;
	
	SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
        	sqLiteDatabase = openOrCreateDatabase("Contact", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ContactInfo" +
            		"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR(30),CONTACT_NO VARCHAR(10),EMAIL VARCHAR(20),ADDRESS TEXT)");

		} catch (Exception e) {
			Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
		}
      
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
     
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
    }

	@Override
	public void onClick(View view) {
		if(view.getId()==R.id.button1){
			Intent intent = new Intent(this,AddContsctActivity.class);
			startActivity(intent);
		}
		else {
			Intent intent = new Intent(this,CViewContactActivity.class);
			startActivity(intent);
			
		}
	}
    
}
