package com.tv.ohce.boundary;

import com.tv.ohce.greet.Greet;
import com.tv.ohce.repliers.ReplyModified;
import com.tv.ohce.repliers.ReplyReverse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class BoundaryValuesTest {
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

    @Test
    @DisplayName("C_1")
    public void modified_input_with_no_index_found() {
        assertNull(ReplyModified.to("La ruta nos aportó otro paso natural", 11111111));
    }

    @Test
    @DisplayName("C_2 with first position")
    public void modified_input_at_1am() {
        assertEquals("Latur a son aportó otro pan osarutal", ReplyModified.to("La ruta nos aportó otro paso natural", 1));
    }

    @Test
    @DisplayName("C_2 with middle position")
    public void modified_input_at_10am() {
        assertEquals("on atur aLs aportó otro paslarutan o", ReplyModified.to("La ruta nos aportó otro paso natural", 10));
    }

    @Test
    @DisplayName("C_2 with last position")
    public void modified_input_at_23am() {
        assertEquals("aL atur son aportó orto osap larutan", ReplyModified.to("La ruta nos aportó otro paso natural", 23));
    }

    @Test
    @DisplayName("Kill mutant: Replaced return value with \"\" for com/tv/ohce/repliers/ReplyModified::to")
    public void modified_input_at_5am() {
        assertNotEquals("", ReplyModified.to("ototo", 0));
    }

    @Test
    public void reverse_the_input() {
        assertEquals("ohce", ReplyReverse.to("echo"));
    }
}
