package my.adp;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.app.Activity;
import android.app.LauncherActivity.ListItem;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListAdaptersExActivity extends Activity {
	List<String> data = new ArrayList<String>();
	int i = 0;
	ArrayAdapter<String> arrayAdapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_checked, data);

		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(arrayAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int arg2,
					long arg3) {
				CheckedTextView item = (CheckedTextView) v;
				
				item.setChecked(!item.isChecked());
				
			}
		});

	}
	
	public void addItem(View v){
		data.add("Option "+i++);
		arrayAdapter.notifyDataSetChanged();
	}
}