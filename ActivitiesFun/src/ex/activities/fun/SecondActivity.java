package ex.activities.fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        
        String firstName = getIntent().getExtras().getString("firstName");
        String lastName = getIntent().getExtras().getString("lastName");
        
        Log.i("Extras","Fist Name:"+firstName);
        
        android.R.layout.
        ((Button)findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SecondActivity.this, ActivitiesFunActivity.class);
				SecondActivity.this.startActivity(intent);
			}
		});
    }
}
