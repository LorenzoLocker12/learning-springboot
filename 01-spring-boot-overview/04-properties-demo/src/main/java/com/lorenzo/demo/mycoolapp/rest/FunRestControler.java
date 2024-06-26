package com.lorenzo.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestControler {

    // inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String name;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for '/teaminfo'

    @GetMapping("/teaminfo")
    public String teamInfo() {
        return String.format("%s from %s", name, teamName);
    }

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
