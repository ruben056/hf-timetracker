package com.example.timetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimeTrackerOpenHelper extends SQLiteOpenHelper {
	
	
	public TimeTrackerOpenHelper(Context context, String dbName, int version) {
		super(context, dbName, null, version);	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table timerecords (_id integer primary key, time text, notes text)");
		ContentValues cv = new ContentValues();
		cv.put("time", "22:30");
		cv.put("notes", "some notes");
		db.insert("timerecords", null,  cv);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("drop table if exists timerecords");
		onCreate(db);
	}

}
