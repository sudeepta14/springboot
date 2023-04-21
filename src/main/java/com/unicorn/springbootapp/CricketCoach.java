package com.unicorn.springbootapp;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice breathing for 15 mins!!!!";
    }
}
