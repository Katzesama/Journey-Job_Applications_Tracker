package com.example.journey;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper{

    // reference: https://blog.csdn.net/zgljl2012/article/details/47055093

    private static final String DB_NAME = "jobTracker.db";//数据库文件名
    private Context mContext;
    public final static int version = 1;

    private static final String App_Table = "Application";
    private static final String Task_Table = "Task";


    public DBhelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create application table
        String create_application_sql = "CREATE TABLE if not exists "+ App_Table +
                "(_id integer primary key autoincrement, appid text, application text)";
        db.execSQL(create_application_sql);
        //create application table
        String create_task_sql = "CREATE TABLE if not exists Tasks"+ Task_Table +
                "(_id integer primary key autoincrement, taskid text, task text)";
        db.execSQL(create_task_sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
