package com.example.texttospeech_app;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	Button btn1;
	EditText et1;
	TextToSpeech textToSpeech;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1 = (Button)findViewById(R.id.button1);
        et1 = (EditText)findViewById(R.id.editText1);
        
        btn1.setOnClickListener(this);
        
        textToSpeech = new TextToSpeech(this, new ConvertTextToSpeech());
        
        
    }
    
    class ConvertTextToSpeech implements OnInitListener{

		@Override
		public void onInit(int arg0) {
				textToSpeech.setLanguage(Locale.UK);			
		}
    	
    }

	@Override
	public void onClick(View arg0) {
		String text = et1.getText().toString();
		textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);		
	}

    
    
}
