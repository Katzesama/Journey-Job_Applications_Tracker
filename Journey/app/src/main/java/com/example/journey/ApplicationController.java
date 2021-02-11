package com.example.journey;

import android.content.Context;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ApplicationController {
    private static ApplicationController INSTANCE = null;
    private Application currentApplication;
    private ArrayList<Application> applicationList;

    private ApplicationController() {};

    public static ApplicationController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationController();
        }
        return(INSTANCE);
    }

    public void createApplication(String jobTitle, String company, String expectedSalary, String location, String description){
        currentApplication = new Application(jobTitle, company, expectedSalary, location, description);
    }

    public void saveNewApplication(Context c){
        Gson gson = new Gson();
        String jsonApplication = gson.toJson(currentApplication);
        DBManager.getInstance(c).insertApplication(currentApplication.getId(), jsonApplication);
    }
}