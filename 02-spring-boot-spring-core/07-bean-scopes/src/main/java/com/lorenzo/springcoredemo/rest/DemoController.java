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

    private Coach anotherCoach;

    //define a constructor for dependecy injection

    @Autowired
    public DemoController(@Qualifier("cricketCoach")Coach coach,
                          @Qualifier("cricketCoach")Coach anotherCoach) {
        System.out.println("In constructor " + this.getClass().getSimpleName());
        this.myCoach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach=" + myCoach + ", anotherCoach=" + anotherCoach + ", myCoach == anotherCoach=" +
                (myCoach == anotherCoach);
    }



}
