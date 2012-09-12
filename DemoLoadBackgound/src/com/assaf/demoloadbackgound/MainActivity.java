package com.assaf.demoloadbackgound;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;

import com.assaf.demoloadbackgound.listener.BackgroundSetter;

/**
 * A demo application that shows how to choose a file from the gallery and set it as the layout's background
 * @author assaf
 *
 */
public class MainActivity extends Activity {

    public static final int CHOOSE_BG = 1;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.button1).setOnClickListener(new BackgroundSetter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK){
			switch (requestCode) {
			case CHOOSE_BG:
				Uri imageUri = data.getData(); //get the returned image uri
		        try {
					Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
					onBitmapReady(bitmap);
				} catch (Exception e) {
					Log.e("TAG", "Something went wrong - "+e.getMessage());
				}
                break;

			default:
				break;
			}
		}
	}
    
	/**
	 * Here you can do whatever you want with the bitmap
	 * @param bitmap
	 */
    @SuppressLint("NewApi")
	private void onBitmapReady(Bitmap bitmap){
    	
    	//Wrap the bitmap with a Bitmap drawable so it can be set as a view background
    	//This is only supported since API 16
    	Drawable background = new BitmapDrawable(getResources(),bitmap);
    	findViewById(R.id.bg).setBackground(background);
    	
    	//You can instead draw the bitmap on a canvas
    }
}
