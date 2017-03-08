package com.example.sms_app;


import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
//import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1;
	EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1 = (Button)findViewById(R.id.button1);
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);

        btn1.setOnClickListener(this);
    }
	@Override
	public void onClick(View arg0) {

		String num = et1.getText().toString();
		String message = et2.getText().toString();
		
		SmsManager smsManager = SmsManager.getDefault();
		
		smsManager.sendTextMessage(num, null, message, null, null);
	}

}
