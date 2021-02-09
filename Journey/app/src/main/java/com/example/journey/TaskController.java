package com.example.journey;

import java.util.ArrayList;

public class TaskController {
    private static TaskController INSTANCE = null;
    private ArrayList<Task> taskList;

    private TaskController() {};

    public static TaskController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskController();
        }
        return(INSTANCE);
    }


}
