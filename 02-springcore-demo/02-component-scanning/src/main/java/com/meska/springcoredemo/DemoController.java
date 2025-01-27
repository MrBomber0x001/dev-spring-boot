package com.meska.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for the dependency injection
    @Autowired // annotation to tell spring to inject the dependency
    /**
     * In our case, we can remove this Annotation because you've only one constructor
     * no no need
     */
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }


    @GetMapping("/daily_workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
