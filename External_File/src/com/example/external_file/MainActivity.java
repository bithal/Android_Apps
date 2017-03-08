package com.example.external_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
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
		if (view.getId()==R.id.button1) {
			String content = et1.getText().toString();
			
			File root = Environment.getExternalStorageDirectory();
			File dir = new File(root.getAbsoluteFile()+"/Lakshaya");
			dir.mkdirs();
			
			File file = new File(dir,"data.txt");
			
			try {
				FileOutputStream f = new FileOutputStream(file);
				f.write(content.getBytes());
				f.close();
				
			} catch (Exception e) {
				Toast.makeText(this, "Error!",Toast.LENGTH_SHORT).show();
			}
		}
		
		else if (view.getId()==R.id.button2) {
			File root = Environment.getExternalStorageDirectory();
			File dir = new File(root.getAbsoluteFile()+"/Lakshaya");
			File file = new File(dir,"data.txt");
			
			try {
				FileInputStream fInputStream = new FileInputStream(file);
				BufferedReader bReader = new BufferedReader(new InputStreamReader(fInputStream));
				String fdata = "";
				String data = "";
				
				while((data = bReader.readLine())!=null){
					fdata = fdata+data+"\n";
				}
				et1.setText(fdata);
			} catch (Exception e) {
				Toast.makeText(this, "Error!",Toast.LENGTH_SHORT).show();
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
