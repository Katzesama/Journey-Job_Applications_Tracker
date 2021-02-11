package com.example.journey;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestDBManager {
    @Mock
    Context mockContext;

    private DBManager dbmanager;

    @Before
    public void Setup(){
        dbmanager = DBManager.getInstance(mockContext);
    }

    @After
    public void ClearDB(){
        dbmanager.close();
    }

    @Test
    public void InsertApplication() {

    }
}
