package com.example.journey;

public class TaskController {
    private static TaskController INSTANCE = null;

    private TaskController() {};

    public static TaskController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskController();
        }
        return(INSTANCE);
    }


}
