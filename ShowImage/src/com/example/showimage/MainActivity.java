package com.example.showimage;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{

	ImageView iView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        iView = (ImageView) findViewById(R.id.imageView1);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        
    }
	@Override
	public void onClick(View v) {
		
		if(v.getId()==R.id.button1){
			iView.setImageResource(R.drawable.ic_launcher);
		}
		else{
			iView.setImageResource(R.drawable.python);
		}
		
	}


   
    
}
