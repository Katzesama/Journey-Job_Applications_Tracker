package com.example.journey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private static DBManager INSTANCE = null;
    private static DBhelper dbhelper;

    private Context context;

    private SQLiteDatabase database;

    // reference: https://blog.csdn.net/cunchi4221/article/details/107476789
    private DBManager(Context c) {
        dbhelper = new DBhelper(c);
        database = dbhelper.getWritableDatabase();
    }

    public static DBManager getInstance(Context c) {
        if (INSTANCE == null) {
            INSTANCE = new DBManager(c);
        }
        return(INSTANCE);
    }

    public void close() {
        dbhelper.close();
    }

    public void insert(String name, String desc) {
        ContentValues contentValue = new ContentValues();
        //contentValue.put(DBhelper.SUBJECT, name);
        //contentValue.put(DBhelper.DESC, desc);
        //database.insert(DBhelper.TABLE_NAME, null, contentValue);
    }

    //public Cursor fetch()
    public void fetch(){
        //String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.SUBJECT, DatabaseHelper.DESC };
        //Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        /*
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;

         */
    }

    public int update(long _id, String name, String desc) {
        /*
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESC, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;

         */
        return 1;
    }

    public void delete(long _id) {
        // database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }


}

