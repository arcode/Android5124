package ex.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Attache external handler example
        Button plus = (Button) findViewById(R.id.plusBtn);
        //plus.setOnClickListener(new CalculatorListener());
        //plus.setOnClickListener(new MyClickHandler());
        
        plus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("Inner class", "Button Clicked "+v.getId());
				
			}
		});
        
    }
    
    public void doCalculation(View v){
    	Log.i("Calculator", "Button "+v.getId()+" clicked");
    	
    	int id = v.getId();
    	EditText num1 = (EditText) findViewById(R.id.num1);
    	EditText num2 = (EditText) findViewById(R.id.num2);
    	
    	double d1 = Double.parseDouble(num1.getText().toString());
    	double d2 = Double.parseDouble(num2.getText().toString());
    	
    	double result = 0;
    	
    	switch (id) {
		case R.id.plusBtn:
			result = d1+d2;
			break;

		case R.id.minusBtn:
			result = d1-d2;
			break;
			
		case R.id.multiplyBtn:
			result = d1*d2;
			break;
		
		case R.id.divideBtn:
			if(d2!=0){
				result = d1/d2;
			}
			break;
		default:
			break;
		}
    	
    	EditText output = (EditText) findViewById(R.id.output);
    	output.setText(""+result);
    }
    
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options_menu, menu);
		return true;
	}

    /**
     * Add functionality to the menu item click
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		
		switch (id) {
		case R.id.deleteBtn:
			Toast.makeText(this, "Clear menu selected", Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}
		return true;
	}



	private class MyClickHandler implements OnClickListener{

		@Override
		public void onClick(View v) {
			Log.i("MyClickHandler", "Button Clicked "+v.getId());
			
		}
    	
    }
}