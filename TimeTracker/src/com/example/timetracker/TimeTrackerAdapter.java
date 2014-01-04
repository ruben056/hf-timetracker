package com.example.timetracker;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimeTrackerAdapter extends CursorAdapter {

	
	public TimeTrackerAdapter(Context ctx, Cursor cursor){
		super(ctx, cursor);
	}
	
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		
		TextView time = ((TextView)view.findViewById(R.id.time_view));
		TextView notes = ((TextView)view.findViewById(R.id.notes_view));
		
		time.setText(cursor.getString(cursor.getColumnIndex("time")));
		notes.setText(cursor.getString(cursor.getColumnIndex("notes")));
	}
	
	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup parent) {
		return initView(parent);
	}
	
	private View initView(ViewGroup parent){		
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		return inflater.inflate(R.layout.time_list_item, parent, false);
		
	}
}
