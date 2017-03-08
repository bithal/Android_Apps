package com.example.internal_file;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ContentHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText et1;
	Button btn1,btn2,btn3,btn4;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1 = (EditText) findViewById(R.id.editText1);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        
        
    }

	@Override
	public void onClick(View view) {
		String fileName = "data.txt";
		if(view.getId()==R.id.button1){
			String content = et1.getText().toString();
			
			try {
				FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
				fos.write(content.getBytes());
				fos.close();
			} catch (Exception e) {
				Toast.makeText(this, "File Not Created", Toast.LENGTH_SHORT).show();
			}
		}
		else if(view.getId()==R.id.button2){
			try {
				InputStream inputStream = openFileInput(fileName);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				String rec_Data = "",fData ="";
				
				while((rec_Data=bufferedReader.readLine())!=null){
					fData = fData+rec_Data+"\n";
				}
				et1.setText(fData);
			} catch (Exception e) {
				Toast.makeText(this, "Reading error", Toast.LENGTH_SHORT).show();
			}
		}
		else if (view.getId()==R.id.button3) {
			et1.setText("");
			
		}
		else{
			finish();
		}
	}
    
}
