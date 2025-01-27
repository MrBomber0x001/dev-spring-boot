package com.meska.utils;

import org.springframework.stereotype.Component;

@Component // marks the class as bean makes it available for dependency injection
public class CricketCoach implements Coach {
  @Override
  public String getDailyWorkout(){
      return "bla bla";
  }
}
