package com.example.sqlitedatabase;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText et1,et2;
	Button btn1,btn2;
	
	SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sqLiteDatabase = openOrCreateDatabase("Info", MODE_PRIVATE, null);
        
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Contact_info(NAME VARCHAR(30),CONTACT_NO NUMBER(10))");
        
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
         
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1){
			String name = et1.getText().toString();
			String contact = et2.getText().toString();
			
			sqLiteDatabase.execSQL("INSERT INTO Contact_info VALUES('"+name+"','"+contact+"')");
			
			Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
		}
		else {
			Intent intent = new Intent(this,DisplayActivity.class);
			startActivity(intent);
		}
	}

}
