package com.example.listviewevent;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{

	ArrayList<String> course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView lView = (ListView)findViewById(R.id.listView1);
        
        course = new ArrayList<String>();
        
        course.add("Java");
        course.add("Android");
        course.add("Php");
        course.add("Big Data");
        course.add("Hadoop");
        
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, course);
        lView.setAdapter(aa);
        
        lView.setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		String Cor = course.get(pos);
		Toast.makeText(this, "Course : "+Cor, Toast.LENGTH_SHORT).show();
	}


    
}
