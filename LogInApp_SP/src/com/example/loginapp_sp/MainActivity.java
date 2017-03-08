package com.example.loginapp_sp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	EditText et1,et2;
	Button btn;
	CheckBox checkBox;
	
	SharedPreferences sp;
	Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        btn = (Button)findViewById(R.id.button1);
        checkBox = (CheckBox)findViewById(R.id.checkBox1);
        btn.setOnClickListener(this);
        
        sp = getApplicationContext().getSharedPreferences("My_pref", MODE_PRIVATE);
        editor = sp.edit();
        String userName = sp.getString("userName", null);
        if(userName!=null){

        	Intent intent = new Intent(this,Home.class);
        	
        	startActivity(intent);
        	finish();
        	
        }
        
    }

	@Override
	public void onClick(View arg0) {
		if(checkBox.isChecked()){
			if(et1.getText().toString().equals("admin") && et2.getText().toString().equalsIgnoreCase("admin")){
				editor.putString("userName", et1.getText().toString());
				editor.putString("Pass", et2.getText().toString());
				editor.commit();
				
				Intent intent = new Intent(this,Home.class);
	        	
	        	startActivity(intent);
	        	finish();
			}
		}
		else{
			if(et1.getText().toString().equals("admin") && et2.getText().toString().equalsIgnoreCase("admin")){
				Intent intent = new Intent(this,Home.class);
	        	
	        	startActivity(intent);
	        	finish();
		}
	}
}
    


    
}
