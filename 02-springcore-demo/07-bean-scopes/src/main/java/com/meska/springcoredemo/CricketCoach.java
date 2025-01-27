package com.meska.springcoredemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // marks the class as bean makes it available for dependency injection
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // by default all beans are singleton
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    // define our init (post construct
    @PostConstruct
    public void doStuff(){
        System.out.println("Init" + getClass().getSimpleName());
    }

    @PreDestroy
    public void doOtherStuff(){
        System.out.println("Wooooh");
    }


  @Override
  public String getDailyWorkout(){
      return "bla bla";
  }
}
