package com.example.journey;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class Task {

    private String Title;
    private String Location;
    private Boolean Complete;
    private Date dateTime;
    private String Note;

    private String id;
    private String applicationID;

    public Task(){
        this.id = UUID.randomUUID().toString();
    }

    /**
     * @return the title of the task
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param title A title for the task, e.g. Phone Interview
     */
    public void setTitle(String title) {
        Title = title;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Boolean getComplete() {
        return Complete;
    }

    public void setComplete(Boolean complete) {
        Complete = complete;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getId() {
        return id;
    }
}
