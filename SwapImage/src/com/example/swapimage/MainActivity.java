package com.example.swapimage;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	ImageView iv1,iv2;
	int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button) findViewById(R.id.button1);
        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        
        btn.setOnClickListener(this);
    }
	@Override
	public void onClick(View arg0) {

		if(c==0){
			iv1.setImageResource(R.drawable.python);
			iv2.setImageResource(R.drawable.ic_launcher);
			c=1;
		}
		else {
			iv2.setImageResource(R.drawable.python);
			iv1.setImageResource(R.drawable.ic_launcher);
			c=0;
		}
	}


    
    
}
