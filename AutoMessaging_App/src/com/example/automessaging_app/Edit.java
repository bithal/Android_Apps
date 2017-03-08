package com.example.automessaging_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Edit extends Activity implements OnClickListener{

	Button btn1,btn2;
	DBHandler dbHandler;
	SQLiteDatabase db;
	String id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		
		db = openOrCreateDatabase("Test", MODE_PRIVATE, null);
        dbHandler = new DBHandler(db);
		Bundle bundle = getIntent().getExtras();
		id = bundle.getString("id");
		btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		if (view.getId()==R.id.button1) {
			dbHandler.Delete(id);
			Toast.makeText(this, "Delete succussful", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this,Show.class);
			startActivity(intent);
		}
		else{
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
		}		
	}

}
