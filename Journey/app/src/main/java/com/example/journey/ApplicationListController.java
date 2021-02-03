package com.example.journey;

import java.util.ArrayList;

public class ApplicationListController {
    private static ApplicationListController INSTANCE = null;
    private ArrayList<Application> applicationList;

    // other instance variables can be here

    private ApplicationListController() {
        applicationList = new ArrayList<>();
    };

    public static ApplicationListController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationListController();
        }
        return(INSTANCE);
    }

    public ArrayList<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(ArrayList<Application> applicationList) {
        this.applicationList = applicationList;
    }
}
