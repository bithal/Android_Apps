package com.example.automessaging_app;

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
		db.execSQL("CREATE TABLE IF NOT EXISTS Message_Info" +
				"(ID INTEGER PRIMARY KEY AUTOINCREMENT,MOBILE_NO VARCHAR(11),INCOMMING_TEXT TEXT,OUTGOING_TEXT TEXT)");
	}
	public void Add(String mob_no,String inc_txt,String out_txt) {
		db.execSQL("INSERT INTO Message_Info " +
				"(MOBILE_NO,INCOMMING_TEXT,OUTGOING_TEXT) VALUES('"+mob_no+"','"+inc_txt+"','"+out_txt+"')");		
	}
	public Cursor Select() {
        Cursor cursor = db.rawQuery("SELECT * FROM Message_Info", null);
        if (cursor!=null) {
        	return cursor;
		}
        return null;
	}
	public String Select_Sms(String number, String inc_sms) {
		String out_txt=null;
		Cursor cursor = db.rawQuery("SELECT OUTGOING_TEXT FROM Message_Info " +
				"WHERE MOBILE_NO = '"+number+"' AND INCOMMING_TEXT = '"+inc_sms+"'", null);
		if (cursor!=null) {
			cursor.moveToFirst();
			while(!cursor.isAfterLast()){
				out_txt = cursor.getString(0);
				cursor.moveToNext();
			}
			return out_txt;
		}
        return null;
	}
	public void Update(String message) {
		db.execSQL("UPDATE Message_Info " +
				"SET MESSAGE='"+message+"' WHERE ID = 1");
	}
	public void Delete(String id) {
		db.execSQL("DELETE  FROM Message_Info WHERE ID = "+id);
	}
	public void Clear() {
		db.delete("Message_Info", null, null);
	}
}
