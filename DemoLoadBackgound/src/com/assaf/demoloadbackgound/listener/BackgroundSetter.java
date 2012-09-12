package com.assaf.demoloadbackgound.listener;

import com.assaf.demoloadbackgound.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class BackgroundSetter implements OnClickListener {

	private Activity context;
	
	public BackgroundSetter(Activity context) {
		this.context = context;
	}

	public void onClick(View arg0) {
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		context.startActivityForResult(Intent.createChooser(intent, "Select Picture"), MainActivity.CHOOSE_BG );
	}
}
