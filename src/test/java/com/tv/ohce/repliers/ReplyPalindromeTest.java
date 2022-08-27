package com.tv.ohce.repliers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReplyPalindromeTest {
    @Test
    public void identify_palindromes() {
        assertEquals("¡Bonita palabra!", ReplyPalindrome.to("oto"));
    }

    @Test
    public void ignore_others() {
        assertNull(ReplyPalindrome.to("echo"));
    }
}
