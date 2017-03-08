package com.example.implicit_multi_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		
		Intent intent = new Intent("activity");
		startActivity(intent);
		
	}


   
    
}
