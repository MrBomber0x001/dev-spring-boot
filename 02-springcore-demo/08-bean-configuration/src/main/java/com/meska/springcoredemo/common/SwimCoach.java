package com.meska.springcoredemo.common;

// represent a 3rd-party class that's no configred to be @Component
public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "swim forrest swim!";
    }
}
