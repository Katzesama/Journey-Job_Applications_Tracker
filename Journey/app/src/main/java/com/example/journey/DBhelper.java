package com.example.journey;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper{

    // reference: https://blog.csdn.net/zgljl2012/article/details/47055093

    public static final String DB_NAME = "jobTracker.db";//数据库文件名
    private Context mContext;
    public final static int version = 1;

    // Table names
    private static final String App_Table = "Application";
    private static final String Task_Table = "Task";

    // Application Table columns
    private static final String A_ID = "_id";
    private static final String AppID = "appID";
    private static final String Application = "application";

    // Task Table columns
    private static final String T_ID = "_id";
    private static final String TaskID = "taskID";
    private static final String Task = "task";

    private static DBhelper INSTANCE = null;

    private DBhelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    public static DBhelper getInstance(Context c) {
        if (INSTANCE == null) {
            INSTANCE = new DBhelper(c);
        }
        return(INSTANCE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create application table
        String create_task_sql = "CREATE TABLE if not exists "+ Task_Table +
                "(_id integer primary key autoincrement, taskID text unique, task text)";
        db.execSQL(create_task_sql);
        //create application table
        String create_application_sql = "CREATE TABLE if not exists "+ App_Table +
                "(_id integer primary key autoincrement, appID text unique, application text)";
        db.execSQL(create_application_sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

    public static String getApp_Table() {
        return App_Table;
    }

    public static String getTask_Table() {
        return Task_Table;
    }

    public static String getAId() {
        return A_ID;
    }

    public static String getAppID() {
        return AppID;
    }

    public static String getApplication() {
        return Application;
    }

    public static String getTId() {
        return T_ID;
    }

    public static String getTaskID() {
        return TaskID;
    }

    public static String getTask() {
        return Task;
    }

    public static String getDbName(){return DB_NAME;}
}
