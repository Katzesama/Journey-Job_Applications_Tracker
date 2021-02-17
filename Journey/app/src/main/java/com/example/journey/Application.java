package com.example.journey;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.time.LocalDate;;
import java.util.UUID;


/**
 * A class representing an Application object that contains task objects, with related details.
 * Created by Iris on 2020/1/27.
 */
public class Application {
    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY = 4;
    public static final int SATURDAY = 5;
    public static final int SUNDAY = 6;

    private String jobTitle;
    private String Company;
    private String expectedSalary;
    private Integer Rating;
    private String Location;
    private String Status;
    private LocalDate appliedDate;
    private String Description;

    private String id;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Application(String jobTitle, String company, String expectedSalary, String location, String description) {
        this.jobTitle = jobTitle;
        Company = company;
        this.expectedSalary = expectedSalary;
        Rating = 0;
        Location = location;
        //Status = status;
        appliedDate = LocalDate.now();
        id = UUID.randomUUID().toString();
        Description = description;
    }

    /**
     * @return the job title of the application
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle A job title for a job application
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return the job title of the application
     */
    public String getCompany() {
        return Company;
    }

    /**
     * @param company A job title for a job application
     */
    public void setCompany(String company) {
        Company = company;
    }


    public String getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public Integer getRating() {
        return Rating;
    }

    public void setRating(Integer rating) {
        Rating = rating;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getId() {
        return id;
    }
}
