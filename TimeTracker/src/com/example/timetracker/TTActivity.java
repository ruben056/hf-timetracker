package com.example.timetracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class TTActivity extends Activity {

	
	public static final int TIME_ENTRY_REQUEST_CODE = 1; // used to link response to request...

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tt);
		
		ListView lv = (ListView)findViewById(R.id.times_list);
		TimeTrackerAdapter tta = new TimeTrackerAdapter();
		lv.setAdapter(tta);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.time_menu, menu);
		return true;
	}

	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {		
		
		if(item.getItemId() == R.id.add_time_menu_item){
			Intent intent = new Intent(this, AddTimeActivity.class);
			startActivityForResult(intent, TIME_ENTRY_REQUEST_CODE);
			return true;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {	
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == TIME_ENTRY_REQUEST_CODE){
			if(resultCode == RESULT_OK){
				String time = data.getStringExtra("time");
				String notes = data.getStringExtra("notes");
				
				ListView lv = (ListView)findViewById(R.id.times_list);
				TimeTrackerAdapter tta = ((TimeTrackerAdapter)lv.getAdapter());
				tta.addTimeRecord(new TimeRecord(time, notes));
				tta.notifyDataSetChanged();
			}
		}
	}
}
