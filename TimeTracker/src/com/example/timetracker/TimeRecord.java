package com.example.timetracker;

/**
 * This is the data record that will be used to fill the adapter hence list with
 * 
 * @author ruben
 *
 */
public class TimeRecord {

	private String time;
	private String notes;
	
	public TimeRecord(String time, String notes){
		this.time = time;
		this.notes = notes;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
