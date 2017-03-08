package com.example.incomingcall_message;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHandler {

	SQLiteDatabase db;
	public DBHandler() {
		
	}
	
	DBHandler(SQLiteDatabase db){
		this.db = db;
	}
	public void Create() {
		db.execSQL("CREATE TABLE IF NOT EXISTS Call_Message(ID INTEGER PRIMARY KEY AUTOINCREMENT,MESSAGE TEXT)");
	}
	public void Add(String message) {
		db.execSQL("INSERT INTO Call_Message (MESSAGE) VALUES('"+message+"')");		
	}
	public Cursor Select() {
        Cursor cursor = db.rawQuery("SELECT * FROM Call_Message", null);
        return cursor;
	}
	public void Update(String message) {
		db.execSQL("UPDATE Call_Message " +
				"SET MESSAGE='"+message+"' WHERE ID = 1");
	}
	public void Clear() {
		db.delete("Call_Message", null, null);
	}
}
