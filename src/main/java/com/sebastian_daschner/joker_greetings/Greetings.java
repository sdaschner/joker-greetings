package com.sebastian_daschner.joker_greetings;

import javax.inject.Inject;

public class Greetings {

    @Inject
    @Config("greeting.name")
    private String greeting;

    public String calculateGreeting(String name) {
        return greeting + ", " + name;
    }

}
