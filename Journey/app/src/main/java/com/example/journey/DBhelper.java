package com.example.journey;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper{

    // reference: https://blog.csdn.net/zgljl2012/article/details/47055093

    private static final String DB_NAME = "jobApplications.db";//数据库文件名
    private static SQLiteDatabase INSTANCE;
    private Context mContext;
    public final static int version = 1;

    private DBhelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.mContext=context;
    }

    public SQLiteDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DBhelper(mContext).getWritableDatabase();
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.beginTransaction();
        //创建邮件表
        String create_mail_sql = "CREATE TABLE if not exists [Test]"+
                "(_id integer primary key autoincrement,person text)";
        db.execSQL(create_mail_sql);

        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
