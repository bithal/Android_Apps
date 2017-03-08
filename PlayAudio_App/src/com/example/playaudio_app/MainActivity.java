package com.example.playaudio_app;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1,btn2;
	MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        
        mPlayer = MediaPlayer.create(this, R.raw.a);
    }
	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.button1) {
			mPlayer.start();
		} else {
			mPlayer.pause();
		}
		
	}

}
