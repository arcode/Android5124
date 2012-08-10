package ex.calculator;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class CalculatorListener implements OnClickListener {

	@Override
	public void onClick(View v) {
		Log.i("CalculatorListener", "Button Clicked!!! "+v.getId());
		//Add any logic
	}

}
