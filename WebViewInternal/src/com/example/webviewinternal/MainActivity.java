package com.example.webviewinternal;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        WebView wv =(WebView)findViewById(R.id.webView1);
        
        wv.loadUrl("file:///android_asset/WebPages/test.html");
    }


    
    
}
