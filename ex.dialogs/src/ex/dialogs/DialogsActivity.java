package ex.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DialogsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Toast toast = Toast.makeText(this, "Thanks for flying Delta", Toast.LENGTH_LONG);
        toast.show(); 

        
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
			
        	@Override
			public void onClick(View v) {
				AlertDialog alertDialog = new AlertDialog.Builder(DialogsActivity.this).create();
				alertDialog.setTitle("Please be quiet");
				alertDialog.setMessage("This is very disturbing!");
				alertDialog.show();
				
			}
		});
    }
}