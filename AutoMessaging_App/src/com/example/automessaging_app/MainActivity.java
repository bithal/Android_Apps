package com.example.automessaging_app;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1,btn2;
	EditText et1,et2,et3;
	SQLiteDatabase db;
	DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db = openOrCreateDatabase("Test", MODE_PRIVATE, null);
        dbHandler = new DBHandler(db);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        
        

    }
	@Override
	public void onClick(View view) {
		if (view.getId()==R.id.button1) {
			String mob_no = et1.getText().toString();
			String inc_txt = et2.getText().toString();
			String out_txt = et3.getText().toString();
			
			dbHandler.Create();
			dbHandler.Add(mob_no, inc_txt, out_txt);
			Toast.makeText(this, "Add succussful", Toast.LENGTH_SHORT).show();
		}
		else{
			Intent intent = new Intent(this,Show.class);
			startActivity(intent);
		}
	}

}
