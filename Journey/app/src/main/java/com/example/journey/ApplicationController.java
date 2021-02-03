package com.example.journey;

public class ApplicationController {
    private static ApplicationController INSTANCE = null;

    private ApplicationController() {};

    public static ApplicationController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationController();
        }
        return(INSTANCE);
    }
}