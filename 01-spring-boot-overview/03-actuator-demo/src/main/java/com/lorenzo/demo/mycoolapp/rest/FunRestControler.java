package com.lorenzo.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestControler {

    // expose '/' that return "Hello World"
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "run a hard 5k";
    }

    // expose a new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getFortune() {
        return "Today is your lucky day";
    }
}
