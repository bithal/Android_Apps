package com.example.imagecapture;


import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	ImageView imageView;   
	Button btn;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn = (Button)findViewById(R.id.button1);
        imageView = (ImageView)findViewById(R.id.imageView1);

        btn.setOnClickListener(this);

    }
	@Override
	public void onClick(View arg0) {

		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 0);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 0 && resultCode == RESULT_OK){
			Bundle ob = data.getExtras();
			Bitmap bitmap = (Bitmap)ob.get("data");
			
			imageView.setImageBitmap(bitmap);
	}

}
}
