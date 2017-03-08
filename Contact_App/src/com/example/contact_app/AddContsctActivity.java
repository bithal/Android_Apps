package com.example.contact_app;

import android.os.Bundle;
import android.renderscript.Element;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContsctActivity extends Activity implements OnClickListener{

	EditText et1,et2,et3,et4;
	Button btn1;
	SQLiteDatabase sqLiteDatabase;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_contsct);
		
		 sqLiteDatabase = openOrCreateDatabase("Contact", MODE_PRIVATE, null);
	        
	        btn1 = (Button)findViewById(R.id.button1);
	        et1 = (EditText)findViewById(R.id.editText1);
	        et2 = (EditText)findViewById(R.id.editText2);
	        et3= (EditText)findViewById(R.id.editText3);
	        et4 = (EditText)findViewById(R.id.editText4);
	        
	        btn1.setOnClickListener(this);

	}
	@Override
	public void onClick(View view) {
		String name = et1.getText().toString();
		String contact = et2.getText().toString();
		String email = et3.getText().toString();
		String address = et4.getText().toString();
		
		sqLiteDatabase.execSQL("INSERT INTO ContactInfo (NAME,CONTACT_NO,EMAIL,ADDRESS) VALUES('"+name+"','"+contact+"','"+email+"','"+address+"')");
		
		Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}


}
