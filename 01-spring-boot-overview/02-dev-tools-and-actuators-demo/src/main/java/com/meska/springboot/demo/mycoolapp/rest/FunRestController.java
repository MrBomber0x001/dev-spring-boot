package com.meska.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "Hello, World"
    @Value("${coach.name}")
    private String coachName;
    @GetMapping("/")
    public String sayHello(){
        return "Hello, World!";
    }

    @GetMapping("/workout")
    public String getWorkout(){
        return "Live bla bla another one!";
    }
}
