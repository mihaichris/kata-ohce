package com.tv.ohce.greet;

import java.time.LocalTime;

public class Greet {

    private final String salute;
    public static final String GREET_EVENING = "¡Buenas noches ";
    public static final String GREET_MORNING = "¡Buenos días ";
    public static final String GREET_AFTERNOON = "¡Buenas tardes ";

    public Greet(String name, LocalTime moment) {
        int hour = moment.getHour();
        if (hour >= 6 && hour < 12) {
            this.salute = GREET_MORNING + name + "!";
        } else if (hour >= 12 && hour < 20) {
            this.salute =  GREET_AFTERNOON + name + "!";
        } else {
            this.salute = GREET_EVENING + name + "!";
        }
    }

    @Override
    public String toString() {
        return salute;
    }
}
