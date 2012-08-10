package com.assaf.apps;

import android.app.Activity;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloPrimitiveActivity extends Activity {
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button saveBtn = (Button) findViewById(R.id.saveButton);
        int width = saveBtn.getMeasuredWidth();
        Log.i("PrimitiveActivity", ""+width);
        
        
    }
}