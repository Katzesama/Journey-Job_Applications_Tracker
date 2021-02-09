package com.example.journey;

import java.util.ArrayList;

public class TaskListController {
    private static TaskListController INSTANCE = null;
    private ArrayList<Task> taskList;

    private TaskListController() {
        taskList = new ArrayList<>();
    };

    public static TaskListController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskListController();
        }
        return(INSTANCE);
    }
}