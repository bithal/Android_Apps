package com.example.passdata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button)findViewById(R.id.button1);
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        
        btn.setOnClickListener(this);
    }


   


	@Override
	public void onClick(View arg0) {
		String name = et1.getText().toString();
		String mob = et2.getText().toString();
		
		Intent intent = new Intent(this,Second.class);
		intent.putExtra("name", name);
		intent.putExtra("mob", mob);
		startActivity(intent);
	}
    
}
