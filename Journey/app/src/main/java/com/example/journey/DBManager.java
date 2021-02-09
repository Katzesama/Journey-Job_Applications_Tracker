package com.example.journey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private static DBManager INSTANCE = null;
    private static DBhelper dbhelper;

    private SQLiteDatabase database;

    // reference: https://blog.csdn.net/cunchi4221/article/details/107476789
    private DBManager(Context c) {
        dbhelper = DBhelper.getInstance(c);
        database = dbhelper.getWritableDatabase();
    }

    public static DBManager getInstance(Context c) {
        if (INSTANCE == null) {
            INSTANCE = new DBManager(c.getApplicationContext());
        }
        return(INSTANCE);
    }

    public void close() {
        dbhelper.close();
    }

    public void insertApplication(String id, String object) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DBhelper.getAppID(), id);
        contentValue.put(DBhelper.getApplication(), object);
        database.insert(DBhelper.getTask_Table(), null, contentValue);
    }

    public void insertTask(String name, String desc) {
        ContentValues contentValue = new ContentValues();
        //contentValue.put(DBhelper.SUBJECT, name);
        //contentValue.put(DBhelper.DESC, desc);
        //database.insert(DBhelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetchTasks(){
        String[] columns = new String[] { dbhelper.getTId(), dbhelper.getTaskID(), dbhelper.getTask() };
        Cursor cursor = database.query(dbhelper.getTask_Table(), columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchApplications(){
        String[] columns = new String[] { dbhelper.getAId(), dbhelper.getAppID(), dbhelper.getApplication() };
        Cursor cursor = database.query(dbhelper.getApp_Table(), columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
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

