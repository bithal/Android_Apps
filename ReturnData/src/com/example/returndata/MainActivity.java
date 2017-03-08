package com.example.returndata;

import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	EditText et1,et2;
	Button btn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn = (Button)findViewById(R.id.button1);
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        
        btn.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View arg0) {
		Intent intent = new Intent(this,Second.class);
		intent.putExtra("num1", et1.getText().toString());
		intent.putExtra("num2", et2.getText().toString());
		
		startActivityForResult(intent, 0);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 0 && resultCode == RESULT_OK){
			Bundle ob = data.getExtras();
			String sumString = ob.getString("sum");
			Toast.makeText(this, "Sum : "+sumString, Toast.LENGTH_SHORT).show();
		}
	}


    
}
