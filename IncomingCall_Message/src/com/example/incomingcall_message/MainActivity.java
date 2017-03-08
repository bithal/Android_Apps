package com.example.incomingcall_message;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener,OnItemClickListener{

	Button btn1,btn2,btn3,btn4;
	EditText et1;
	ListView lView1;
	ArrayList<String> arrayList;
	SQLiteDatabase db;
	DBHandler dbHandler;
	SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db = openOrCreateDatabase("Test",MODE_PRIVATE, null);
        sp = getApplicationContext().getSharedPreferences("Message", MODE_PRIVATE);
        dbHandler = new DBHandler(db);
        
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
//        btn4 = (Button) findViewById(R.id.button4);
        
        et1 = (EditText) findViewById(R.id.editText1);
        lView1 = (ListView) findViewById(R.id.listView1);
        
        arrayList = new ArrayList<String>();
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);
        
        lView1.setOnItemClickListener(this);
        dbHandler.Create();
        		
    }
    public void Show() {
		Cursor cursor = dbHandler.Select();
		 if(cursor!=null)
	        {
	        	cursor.moveToFirst();
	        	while (!cursor.isAfterLast())
	        	{
	        		arrayList.add(cursor.getString(1));
					cursor.moveToNext();
				}
	        }
	        else
	        {
	        	arrayList.add("Record not found");
	        }
	        cursor.close();
	        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
	    	lView1.setAdapter(aa);
	}
	@Override
	public void onClick(View view) {
		if (view.getId()==R.id.button1) {
			String message = et1.getText().toString();
			dbHandler.Add(message);
			
		}
		else if (view.getId()==R.id.button2) {
			dbHandler.Clear();
			arrayList.clear();
		}
//		else if (view.getId()==R.id.button4) {
//			Editor editor = sp.edit();
//			editor.putString("message", et1.getText().toString());
//			editor.commit();
//		}
		else {
			arrayList.clear();
			Show();
		}
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		et1.setText(arrayList.get(pos));
	}
    
}
