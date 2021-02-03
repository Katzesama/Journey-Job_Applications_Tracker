package com.example.journey;

import java.util.ArrayList;
import java.time.LocalDate;;
import java.util.UUID;


/**
 * A class representing an Application object that contains task objects, with related details.
 * Created by Iris on 2020/1/27.
 */
public class Application {
    private static final int MONDAY = 0;
    private static final int TUESDAY = 1;
    private static final int WEDNESDAY = 2;
    private static final int THURSDAY = 3;
    private static final int FRIDAY = 4;
    private static final int SATURDAY = 5;
    private static final int SUNDAY = 6;

    private String jobTitle;
    private String Company;
    private String expectedSalary;
    private Integer Rating;
    private String Location;
    private String Status;
    private LocalDate appliedDate;
    private String Description;

    private String id;

    public Application(){
        this.appliedDate = LocalDate.now();
        this.id = UUID.randomUUID().toString();
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
     * @param Company A job title for a job application
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
