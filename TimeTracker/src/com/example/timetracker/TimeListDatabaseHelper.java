package com.example.timetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TimeListDatabaseHelper {

	private static final int VERSION = 6;
	private static final String DBNAME = "timetracker.db";
	private static final String TABLENAME = "timerecords";
	
	public static final String COLID = "_id";
	public static final String COLTIME = "time";
	public static final String COLNOTES = "notes";
	
	private TimeTrackerOpenHelper openHelper;
	private SQLiteDatabase database;
	
	
	public TimeListDatabaseHelper(Context context){
		openHelper = new TimeTrackerOpenHelper(context, DBNAME, VERSION);
		database = openHelper.getWritableDatabase();
	}
	
	public void saveTimeRecord(TimeRecord tr){				
		ContentValues cv = new ContentValues();
		cv.put(COLTIME, tr.getTime());
		cv.put(COLNOTES, tr.getNotes());
		database.insert(TABLENAME, null,  cv);
	}
	
	public Cursor getTimeRecordList(){
		return database.rawQuery("SELECT * FROM " + TABLENAME, null);
	}
}
