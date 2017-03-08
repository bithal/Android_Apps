package com.example.ringprofile_app;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1,btn2,btn3,btn4;
	AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.button1){
			int mode = audioManager.getRingerMode();
			if(mode == 0){
				Toast.makeText(this, "Mode : Silent", Toast.LENGTH_SHORT).show();
			}
			else if(mode == 1){
				Toast.makeText(this, "Mode : Vibret", Toast.LENGTH_SHORT).show();
			}
			else if(mode == 2){
				Toast.makeText(this, "Mode : Normal", Toast.LENGTH_SHORT).show();
			}
		}
		else if (view.getId() == R.id.button2) {
			audioManager.setRingerMode(0);	
			Toast.makeText(this, "Mode : Silent", Toast.LENGTH_SHORT).show();
		}
		else if (view.getId() == R.id.button3) {
			audioManager.setRingerMode(1);
			Toast.makeText(this, "Mode : Vibret", Toast.LENGTH_SHORT).show();

		}
		else if (view.getId() == R.id.button4) {
			audioManager.setRingerMode(2);	
			Toast.makeText(this, "Mode : Normal", Toast.LENGTH_SHORT).show();

		}
	}

    
}
