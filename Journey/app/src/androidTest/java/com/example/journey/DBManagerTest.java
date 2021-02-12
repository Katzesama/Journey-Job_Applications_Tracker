package com.example.journey;

import android.content.Context;

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
        assertNotNull(dbmanager);
    }

    @Test
    public void InsertTask() throws Exception{
        assertNotNull(dbmanager);
    }

    @Test
    public void FetchApplication() throws Exception{
        assertNotNull(dbmanager);
    }

    @Test
    public void FetchTask() throws Exception{
        assertNotNull(dbmanager);
    }

    @Test
    public void DeleteApplication() throws Exception{
        assertNotNull(dbmanager);
    }

    @Test
    public void DeleteTask() throws Exception{
        assertNotNull(dbmanager);
    }

    @Test
    public void UpdateApplication() throws Exception{
        assertNotNull(dbmanager);
    }

    @Test
    public void UpdateTask() throws Exception{
        assertNotNull(dbmanager);
    }
}

