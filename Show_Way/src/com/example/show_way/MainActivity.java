package com.example.show_way;

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

	EditText slat,slon,dlat,dlon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button)findViewById(R.id.button1);
        
        slat = (EditText)findViewById(R.id.editText1);
        slon = (EditText)findViewById(R.id.editText2);
        
        dlat = (EditText)findViewById(R.id.editText3);
        dlon = (EditText)findViewById(R.id.editText4);
        
        btn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		String Slat = slat.getText().toString();
		String Slon = slon.getText().toString();
		String Dlat = dlat.getText().toString();
		String Dlon = dlon.getText().toString();
		
		Intent intent = new Intent(Intent.ACTION_VIEW,
		Uri.parse("http://maps.google.com/maps?f=d&saddr="+Slat+"%20"+Slon+"&daddr="+Dlat+"%20"+Dlon+"&h1=en"));
		startActivity(intent);
	}
    
}
