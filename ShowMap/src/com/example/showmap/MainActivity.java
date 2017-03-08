package com.example.showmap;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	EditText etla,etlo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button)findViewById(R.id.button1);
        etla = (EditText)findViewById(R.id.editText1);
        etlo = (EditText)findViewById(R.id.editText2);
        
        btn.setOnClickListener(this);
    }
	@Override
	public void onClick(View arg0) {
		
		String lat = etla.getText().toString();
		String lon = etlo.getText().toString();
		
		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+lat+","+lon));
		startActivity(intent);
		
	}


   
    
}
