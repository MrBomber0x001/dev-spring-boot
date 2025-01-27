package com.meska.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;

    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

//    @Autowired
//    public void soSomeStuff(Coach theCoach){
//        myCoach = theCoach;
//    }

    @GetMapping("/daily_workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
