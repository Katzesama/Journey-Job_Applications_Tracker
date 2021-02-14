package com.example.journey;

import android.content.Context;
import android.database.Cursor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class DBManagerTest {

    private DBManager dbmanager;

    @Before
    public void Setup(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        dbmanager = DBManager.getInstance(appContext);
        dbmanager.open();
    }

    @After
    public void CloseDB() throws Exception{
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
        dbmanager.insertApplication("UUID01", "application01");
        dbmanager.deleteApplication("UUID01");
        Cursor cursor = dbmanager.fetchApplications();
        assertNull(cursor);
    }

    @Test
    public void DeleteTask() throws Exception{
        dbmanager.insertTask("UUID01", "task01");
        dbmanager.deleteTask("UUID01");
        Cursor cursor = dbmanager.fetchTasks();
        assertNull(cursor);
    }

    @Test
    public void UpdateApplication() throws Exception{
        dbmanager.insertApplication("UUID01", "application01");
        dbmanager.updateApplication("UUID01","application01modified!");
        Cursor cursor = dbmanager.fetchApplications();
        assertNotNull(cursor);
        assertEquals("UUID01", cursor.getString(cursor.getColumnIndex("application01modified!")));
    }

    @Test
    public void UpdateTask() throws Exception{
        dbmanager.insertTask("UUID01", "task01");
        dbmanager.updateTask("UUID01", "task01modified!");
        Cursor cursor = dbmanager.fetchTasks();
        assertNotNull(cursor);
        assertEquals("UUID01", cursor.getString(cursor.getColumnIndex("task01modified!")));
    }
}

