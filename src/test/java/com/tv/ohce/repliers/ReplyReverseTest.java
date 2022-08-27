package com.tv.ohce.repliers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplyReverseTest {
    @Test
    public void reverse_the_input() {
        assertEquals("ohce", ReplyReverse.to("echo"));
    }
}