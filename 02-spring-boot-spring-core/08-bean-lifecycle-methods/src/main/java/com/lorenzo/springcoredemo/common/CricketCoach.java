package com.lorenzo.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }

    // define our init method
    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct " + this.getClass().getSimpleName());
    }
    // define out destroy method
    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy " + this.getClass().getSimpleName());
    }
}
