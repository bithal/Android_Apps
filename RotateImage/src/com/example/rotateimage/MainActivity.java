package com.example.rotateimage;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

@SuppressLint("NewApi") public class MainActivity extends Activity implements OnClickListener{

	ImageView iv1,iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button) findViewById(R.id.button1);
        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        
        btn.setOnClickListener(this);
    }


 	@SuppressLint("NewApi") @Override
	public void onClick(View arg0) {

 		iv1.setRotation(iv1.getRotation()+45);
 		iv2.setRotation(iv2.getRotation()+-45);
 		
	}
    
}
