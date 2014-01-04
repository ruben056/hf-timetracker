package com.example.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTimeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_screen);
	}
	
	
	public void onSave(View v){
		
		Intent intent = getIntent();
		intent.putExtra("time", ((EditText)findViewById(R.id.time_view)).getText().toString());
		intent.putExtra("notes", ((EditText)findViewById(R.id.notes_view)).getText().toString());
		this.setResult(RESULT_OK, intent);
		finish();
	}
	
	
	public void onCancel(View v){
		finish();
	}
}
