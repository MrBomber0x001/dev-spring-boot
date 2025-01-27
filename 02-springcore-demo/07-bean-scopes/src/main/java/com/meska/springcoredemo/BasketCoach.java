package com.meska.springcoredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BasketCoach implements Coach{
    public BasketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        return "welcome from basketBall";
    }
}
