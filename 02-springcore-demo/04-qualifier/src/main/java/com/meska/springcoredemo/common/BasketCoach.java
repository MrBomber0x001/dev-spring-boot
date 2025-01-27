package com.meska.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BasketCoach implements Coach{
    public String getDailyWorkout(){
        return "welcome from basketBall";
    }
}
