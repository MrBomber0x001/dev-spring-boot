package com.meska.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component // marks the class as bean makes it available for dependency injection
@Lazy
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor:" + getClass().getSimpleName());
    }
  @Override
  public String getDailyWorkout(){
      return "bla bla";
  }
}
