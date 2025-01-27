package com.meska.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;
    @Autowired
    public DemoController (@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach anotherOne){
        anotherCoach = anotherOne;
        myCoach = theCoach;

        /**
         * here Both are the same instance!
         */
    }

    @GetMapping("/daily_workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


    @GetMapping("/check")
    public String check(){
        return "Comparison between beans: myCoach === anotherCoach " + (myCoach == anotherCoach);
    }
}
