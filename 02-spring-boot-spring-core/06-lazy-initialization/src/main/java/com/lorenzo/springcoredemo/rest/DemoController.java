package com.lorenzo.springcoredemo.rest;

import com.lorenzo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency

    private Coach myCoach;

    //define a constructor for dependecy injection

    @Autowired
    public DemoController(@Qualifier("cricketCoach")Coach coach) {
        this.myCoach = coach;
        System.out.println("In constructor " + this.getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }



}
