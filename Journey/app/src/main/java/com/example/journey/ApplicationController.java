package com.example.journey;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ApplicationController {
    private static ApplicationController INSTANCE = null;
    private Application currentApplication;
    private ArrayList<Application> applicationList;

    public static final int Newest = 0;
    public static final int Oldest = 1;
    public static final int filterCompany = 0;
    public static final int filterStatus = 1;

    private ApplicationController() {};

    public static ApplicationController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationController();
        }
        return(INSTANCE);
    }

    public void setApplicationList(Context c){
        Cursor cursor = DBManager.getInstance(c).fetchApplications();
    }

    public void createApplication(String jobTitle, String company, String expectedSalary, String location, String description){
        currentApplication = new Application(jobTitle, company, expectedSalary, location, description);
    }

    public void saveNewApplication(Context c){
        Gson gson = new Gson();
        String jsonApplication = gson.toJson(currentApplication);
        DBManager.getInstance(c).insertApplication(currentApplication.getId(), jsonApplication);
    }

    public void deleteApplications(){

    }

    public void updateApplication(){

    }

    public void getApplication(){

    }

    public ArrayList<Application> getAllApplicationList(){
        return applicationList;
    }

    public ArrayList<Application> getFilterApplicationList(int filter, String condition){
        ArrayList<Application> filterList = new ArrayList<>();
        switch (filter){
            case filterCompany:
                for (Application application: applicationList){
                    if (application.getCompany() == condition){
                        filterList.add(0, application);
                    }
                }
            case filterStatus:
                for (Application application: applicationList){
                    if (application.getStatus() == condition){
                        filterList.add(0, application);
                    }
                }
            default:
                break;
        }
        return filterList;
    }

    public ArrayList<Application> getSortApplicationList(int sort){
        ArrayList<Application> sortList = new ArrayList<>();
        switch (sort){
            case Newest:
                Collections.sort(applicationList, new Comparator<Application>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public int compare(Application a1, Application a2) {
                        return a1.getAppliedDate().isAfter(a2.getAppliedDate()) ? 1:0;
                    }
                });
            case filterStatus:
                Collections.sort(applicationList, new Comparator<Application>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public int compare(Application a1, Application a2) {
                        return a1.getAppliedDate().isAfter(a2.getAppliedDate()) ? 1:0;
                    }
                });
            default:
                break;
        }
        return sortList;
    }

}