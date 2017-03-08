package com.example.contact_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity implements OnClickListener {

	EditText et1,et2,et3,et4;
	Button btn1,btn2;
	SQLiteDatabase sqLiteDatabase;
	String Id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		
        sqLiteDatabase = openOrCreateDatabase("Contact", MODE_PRIVATE, null);
		
		Bundle bundle = getIntent().getExtras();
		Id = bundle.getString("Id");
		
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);

        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);
        et4 = (EditText)findViewById(R.id.editText4);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);	
        
		
		Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ContactInfo WHERE ID = "+Id+";", null);
		
		if(cursor!=null){
			cursor.moveToFirst();
			et1.setText(cursor.getString(cursor.getColumnIndex("NAME")));
			et2.setText(cursor.getString(cursor.getColumnIndex("CONTACT_NO")));
			et3.setText(cursor.getString(cursor.getColumnIndex("EMAIL")));
			et4.setText(cursor.getString(cursor.getColumnIndex("ADDRESS")));
		}
		cursor.close();
	}
	@Override
	public void onClick(View view) {
		if(view.getId()==R.id.button1){
			try {
				String name = et1.getText().toString();
				String contNo = et2.getText().toString();
				String email = et3.getText().toString();
				String add = et4.getText().toString();
						
				sqLiteDatabase.execSQL("UPDATE ContactInfo " +
						"SET NAME='"+name+"',CONTACT_NO='"+contNo+"'," +
								"EMAIL='"+email+"',ADDRESS='"+add+"' WHERE ID = "+Id);
				
			
				Toast.makeText(this, "ID = "+Id, Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(this,CViewContactActivity.class);
				startActivity(intent);
			} catch (Exception e) {
				Toast.makeText(this, e+"", Toast.LENGTH_SHORT).show();
			}	
		}
		else {
			sqLiteDatabase.execSQL("DELETE FROM ContactInfo WHERE ID = "+Id+"");
			et1.setText("");
			et2.setText("");
			et3.setText("");
			et4.setText("");
			Intent intent = new Intent(this,CViewContactActivity.class);
			startActivity(intent);
		}
	}

}
