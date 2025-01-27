package com.meska.springcoredemo.rest;

import com.meska.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("custom_bean_id") Coach theCoach){
        myCoach = theCoach;
    }


    @GetMapping("/daily_workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
