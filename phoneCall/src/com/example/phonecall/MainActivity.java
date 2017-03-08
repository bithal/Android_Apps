package com.example.phonecall;

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

	EditText eText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button) findViewById(R.id.button1);
        eText = (EditText) findViewById(R.id.editText1);
        
        btn.setOnClickListener(this);
        
        
    }
	@Override
	public void onClick(View arg0) {

		String num = eText.getText().toString();
		Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+num));
		startActivity(intent);
	}

    
}
