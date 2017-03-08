package com.example.multiplebutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {

		int num1 = Integer.parseInt(et1.getText().toString());
		int num2 = Integer.parseInt(et2.getText().toString());
		
		if(v.getId()==R.id.button1){
			int sum = num1+num2;
			Toast.makeText(this, "Sum: "+sum , Toast.LENGTH_LONG).show();
		}
		else if(v.getId()==R.id.button2){
			int sub = num1-num2;
			Toast.makeText(this, "Sub: "+sub , Toast.LENGTH_LONG).show();
		}
		else if(v.getId()==R.id.button3){
			int sub = num1*num2;
			Toast.makeText(this, "Mul: "+sub , Toast.LENGTH_LONG).show();
		}
		else{
			int sub = num1/num2;
			Toast.makeText(this, "Div: "+sub , Toast.LENGTH_LONG).show();
		}
	}
    
}
