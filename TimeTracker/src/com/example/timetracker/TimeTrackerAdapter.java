package com.example.timetracker;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TimeTrackerAdapter extends BaseAdapter {

	private ArrayList<TimeRecord> times = new ArrayList<TimeRecord>();
	
	
	public TimeTrackerAdapter(){
		times.add(new TimeRecord("38:32", "notes"));
		times.add(new TimeRecord("21:32", "bitje zever enzo"));
		times.add(new TimeRecord("55:55", "notes"));
		times.add(new TimeRecord("11:11", "notes"));
	}
	
	@Override
	public int getCount() {
		return times.size();
	}

	@Override
	public Object getItem(int idx) {
		return times.get(idx);
	}

	@Override
	public long getItemId(int idx) {
		return idx;
	}

	public void addTimeRecord(TimeRecord tr){
		times.add(tr);
	}
	
	@Override
	public View getView(int idx, View view, ViewGroup parent) {
		
		if(view == null){
			view = initView(parent);
		}
		
		TimeRecord tr = times.get(idx);
		((TextView)view.findViewById(R.id.time_view)).setText(tr.getTime());
		((TextView)view.findViewById(R.id.notes_view)).setText(tr.getNotes());
		
		return view;
	}

	private View initView(ViewGroup parent){		
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		return inflater.inflate(R.layout.time_list_item, parent, false);
		
	}
}
