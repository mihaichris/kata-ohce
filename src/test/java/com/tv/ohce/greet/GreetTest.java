package com.tv.ohce.greet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetTest {

    /**
     * Boundary Values ----Start----
     * ===========================================
     */
    @Test
    @DisplayName("M_1 With 6 am")
    public void greetings_at_6am() {
        LocalTime moment = LocalTime.of(6, 0);
        Greet actual = new Greet("Mihai", moment);

        assertEquals(Greet.GREET_MORNING + "Mihai!", actual.toString());
    }

    @Test
    @DisplayName("M_1 With 11 am")
    public void greetings_at_11am() {
        LocalTime moment = LocalTime.of(11, 0);
        Greet actual = new Greet("Mihai", moment);

        assertEquals(Greet.GREET_MORNING + "Mihai!", actual.toString());
    }

    @Test
    @DisplayName("M_2 With 12 am")
    public void greetings_at_12am() {
        LocalTime moment = LocalTime.of(12, 0);
        Greet actual = new Greet("Mihai", moment);

        assertEquals(Greet.GREET_AFTERNOON + "Mihai!", actual.toString());
    }

    @Test
    @DisplayName("M_2 With 19 pm")
    public void greetings_at_19pm() {
        LocalTime moment = LocalTime.of(19, 0);
        Greet actual = new Greet("Mihai", moment);

        assertEquals(Greet.GREET_AFTERNOON + "Mihai!", actual.toString());
    }

    @Test
    @DisplayName("M_3 With 20 pm")
    public void greetings_at_20pm() {
        LocalTime moment = LocalTime.of(20, 0);
        Greet actual = new Greet("Mihai", moment);

        assertEquals(Greet.GREET_EVENING + "Mihai!", actual.toString());
    }

    @Test
    @DisplayName("M_3 With 23 pm")
    public void greetings_at_23am() {
        LocalTime moment = LocalTime.of(23, 0);
        Greet actual = new Greet("Mihai", moment);

        assertEquals(Greet.GREET_EVENING + "Mihai!", actual.toString());
    }

    @Test
    @DisplayName("M_3 With 0 am")
    public void greetings_at_0am() {
        LocalTime moment = LocalTime.of(0, 0);
        Greet actual = new Greet("Mihai", moment);

        assertEquals(Greet.GREET_EVENING + "Mihai!", actual.toString());
    }

    @Test
    @DisplayName("M_3 With 5 am")
    public void greetings_at_5am() {
        LocalTime moment = LocalTime.of(5, 0);
        Greet actual = new Greet("Mihai", moment);

        assertEquals(Greet.GREET_EVENING + "Mihai!", actual.toString());
    }
}