package com.example.playaudio2_app;



import java.lang.reflect.Field;
import java.util.ArrayList;

import android.R.anim;
import android.R.integer;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener{

	SQLiteDatabase sqLiteDatabase;
	Button btn1,btn2,btn3;
	MediaPlayer mPlayer;
	ListView listView;
	int id[];
	ArrayList<String> arrayList;
	int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        listView = (ListView)findViewById(R.id.listView1);
//        try {
//			sqLiteDatabase = openOrCreateDatabase("Audio", MODE_PRIVATE, null);
//			sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AudioList (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,RAW_ID INTEGER");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);    
        try {
			listRaw();
		} catch (Exception e) {
			
		}
		
        Create();
    }
    public void listRaw() throws IllegalAccessException, IllegalArgumentException{
	       Field[] fields = R.raw.class.getFields();
	       arrayList = new ArrayList<String>();
	       id = new int[fields.length];
	       for (int i = 0; i < fields.length; i++) {
	    	   id[i] = fields[i].getInt(fields[i]);
	    	   arrayList.add(fields[i].getName());
		
	       }
	       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,arrayList);
	      listView.setAdapter(adapter);
    }
    public void Create() {
    	mPlayer= MediaPlayer.create(this, id[i]);
	}
   
	@Override
	public void onClick(View view) {
		if (view.getId()==R.id.button2) {
			if(btn2.getText().toString().equals("Play")){
				mPlayer.start();
				btn2.setText("Pause");
			}
			else {
				mPlayer.pause();
			}
		}
		
		else if (view.getId() == R.id.button1) {
			if(i!=0){
				i--;
				mPlayer.stop();
				Create();
				mPlayer.start();
				btn2.setText("Pause");
			}
		}
		else if (view.getId() == R.id.button3) {
			
			if(i!=5){
				i++;
				mPlayer.stop();
				Create();
				mPlayer.start();
				btn2.setText("Pause");
			}
		}
		
	}

}
