package com.example.journey;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import java.io.IOException;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class DBManagerTest{

    private DBManager dbmanager;

    @Before
    public void setDbmanager(){
        Context appContext = ApplicationProvider.getApplicationContext();
        // appContext.deleteDatabase(DBhelper.DB_Name);
        dbmanager = DBManager.getInstance(appContext);
        dbmanager.open();
    }

    @After
    public void closeDbmanager() throws IOException{
        dbmanager.close();
    }

    @Test
    public void InsertApplication() throws Exception{
        dbmanager.insertApplication("UUID01", "application01");
        Cursor cursor = dbmanager.fetchApplications();
        assertNotNull(cursor);
        assertEquals("UUID01", cursor.getString(cursor.getColumnIndex("appID")));
    }

    @Test
    public void InsertTask() throws Exception{
        dbmanager.insertTask("UUID01", "task01");
        Cursor cursor = dbmanager.fetchTasks();
        assertNotNull(cursor);
        assertEquals("UUID01", cursor.getString(cursor.getColumnIndex("taskID")));
    }


    @Test
    public void DeleteApplication() throws Exception{
        dbmanager.deleteApplication("UUID01");
        Cursor cursor = dbmanager.fetchApplications();
        assertEquals(cursor.getCount(), 0);
    }

    @Test
    public void DeleteTask() throws Exception{
        dbmanager.deleteTask("UUID01");
        Cursor cursor = dbmanager.fetchTasks();
        assertEquals(cursor.getCount(), 0);
    }

    @Test
    public void UpdateApplication() throws Exception{
        dbmanager.insertApplication("UUID01", "application01");
        dbmanager.updateApplication("UUID01","application01modified!");
        Cursor cursor = dbmanager.fetchApplications();
        assertNotNull(cursor);
        assertEquals("application01modified!", cursor.getString(cursor.getColumnIndex("application")));
    }

    @Test
    public void UpdateTask() throws Exception{
        dbmanager.insertTask("UUID01", "task01");
        dbmanager.updateTask("UUID01", "task01modified!");
        Cursor cursor = dbmanager.fetchTasks();
        assertNotNull(cursor);
        assertEquals("task01modified!", cursor.getString(cursor.getColumnIndex("task")));
    }
}

