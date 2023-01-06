package com.tv.ohce.repliers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReplyModifiedTest {


    /**
     * Boundary Values  ----Start----
     * ===========================================
     */
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
}
