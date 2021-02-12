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
    }

    public static DBManager getInstance(Context c) {
        if (INSTANCE == null) {
            INSTANCE = new DBManager(c);
        }
        return(INSTANCE);
    }

    public DBManager open() throws SQLException {
        database = dbhelper.getWritableDatabase();
        return this;
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

    public void insertTask(String id, String object) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DBhelper.getTaskID(), id);
        contentValue.put(DBhelper.getTask(), object);
        database.insert(DBhelper.getTask_Table(), null, contentValue);
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

    public int updateApplication(String id, String object) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper.getAppID(), id);
        contentValues.put(dbhelper.getApplication(), object);
        int i = database.update(dbhelper.getApp_Table(), contentValues, dbhelper.getAppID() + " = " + id, null);
        return i;
    }

    public int updateTask(String id, String object) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper.getTaskID(), id);
        contentValues.put(dbhelper.getTask(), object);
        int i = database.update(dbhelper.getTask_Table(), contentValues, dbhelper.getTaskID() + " = " + id, null);
        return i;
    }

    public void deleteApplication(String id) {
        database.delete(dbhelper.getApp_Table(), dbhelper.getAppID() + "=" + id, null);
    }

    public void deleteTask(String id) {
        database.delete(dbhelper.getTask_Table(), dbhelper.getTaskID() + "=" + id, null);
    }


}

