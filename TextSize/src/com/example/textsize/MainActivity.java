package com.example.textsize;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView) findViewById(R.id.textView1);
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }


   


	@Override
	public void onClick(View v) {
		
		if(v.getId()==R.id.button1){
			if(tv.getTextSize()<22){
				tv.setTextSize(tv.getTextSize()+2);
			}
		}
		
		else if(v.getId()==R.id.button2){
				if(tv.getTextSize()>8){
					tv.setTextSize(tv.getTextSize()-2);
				}
		}
		else{
			tv.setTextSize(12);	
		}
		
	}
    
}
