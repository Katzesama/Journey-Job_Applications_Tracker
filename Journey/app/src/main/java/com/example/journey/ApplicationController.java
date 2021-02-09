package com.example.journey;

import android.content.Context;
import com.google.gson.Gson;

public class ApplicationController {
    private static ApplicationController INSTANCE = null;
    private Application application;

    private ApplicationController() {};

    public static ApplicationController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationController();
        }
        return(INSTANCE);
    }

    public void createApplication(String jobTitle, String company, String expectedSalary, String location, String description){
        application = new Application(jobTitle, company, expectedSalary, location, description);
    }

    public void saveNewApplication(Context c){
        Gson gson = new Gson();
        String jsonApplication = gson.toJson(application);
        DBManager.getInstance(c).insertApplication(application.getId(), jsonApplication);
    }
}