package com.tv.ohce.controller;

import com.tv.ohce.greet.Greet;
import infrastructure.console.Console;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

public class OhceConsoleControllerTest {
    private OhceConsoleController ohce;

    @Mock
    private Console console;

    @BeforeEach
    @Timeout(4)
    public void setUp() {
        this.console = Mockito.mock(Console.class);
    }

    /**
     * Partiționare pe clase de echivalență ----Start----
     * ===========================================
     */
    @Test
    @DisplayName("C_1112111")
    public void run_in_the_morning_palindrome_but_no_stop_in_second_try_and_no_modify() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("echo").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 10);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(5)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_MORNING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("ohce");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_1111111")
    public void run_in_the_morning_palindrome_but_no_modify() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 10);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_MORNING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_1111112")
    public void run_in_the_morning_with_palindrome_with_modify() {
        Mockito.when(this.console.read()).thenReturn("Anita la gorda lagartona no traga la droga latina").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 10);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(5)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_MORNING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("anital agord al agart on anotragal adrog al atinA");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("g al atinAotragal adrona nord al agart oanital ag");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_111112")
    public void run_in_the_morning() {
        Mockito.when(this.console.read()).thenReturn("natural").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 10);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(3)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_MORNING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("larutan");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_1111211")
    public void run_in_the_afternoon() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 13);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_AFTERNOON + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_1111212")
    public void run_in_the_afternoon_with_palindrome_with_modify() {
        Mockito.when(this.console.read()).thenReturn("Anita la gorda lagartona no traga la droga latina").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 13);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(5)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_AFTERNOON + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("anital agord al agart on anotragal adrog al atinA");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("tinAal adrog al aganotrart on agal agord al anita");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_111122")
    public void run_in_the_afternoon_with_no_palindrom() {
        Mockito.when(this.console.read()).thenReturn("natural").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 13);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(3)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_AFTERNOON + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("larutan");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_1111311")
    public void run_in_the_evening() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 21);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_1111312")
    public void run_in_the_evening_with_palindrome_with_modify() {
        Mockito.when(this.console.read()).thenReturn("Anita la gorda lagartona no traga la droga latina").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 21);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(5)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("anital agord al agart on anotragal adrog al atinA");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("g al atinAotragal adrona nord al agart oanital ag");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_111132")
    public void run_in_the_evening_with_no_palindrome() {
        Mockito.when(this.console.read()).thenReturn("natural").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 21);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(3)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("larutan");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_112")
    public void run_with_empty_string() {
        Mockito.when(this.console.read()).thenReturn("");
        ohce = new OhceConsoleController(console, 50, 10);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(2)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_MORNING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("Range of chat reached limits.");
    }

    @Test
    @DisplayName("C_113")
    public void run_with_bigger_string() {
        Mockito.when(this.console.read()).thenReturn("natural").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 3, 10);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(2)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_MORNING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("Range of chat reached limits.");
        Mockito.verify(this.console, Mockito.times(0)).print("larutan");
        Mockito.verify(this.console, Mockito.times(0)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C_12")
    public void run_with_smaller_y() {
        Mockito.when(this.console.read()).thenReturn(null);
        ohce = new OhceConsoleController(console, -1, 10);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print("MaxChatLength must not be smaller than 0.");
    }

    @Test
    @DisplayName("C_2")
    public void run_with_smaller_n() {
        Mockito.when(this.console.read()).thenReturn(null);
        ohce = new OhceConsoleController(console, null, -1);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print("Time must be between 0 and 23.");
    }

    @Test
    @DisplayName("C_3")
    public void run_with_bigger_n() {
        Mockito.when(this.console.read()).thenReturn(null);
        ohce = new OhceConsoleController(console, null, 25);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print("Time must be between 0 and 23.");
    }

    /**
     * Testarea valorilor de frontieră ----Start----
     * ===========================================
     */
    @Test
    @DisplayName("N1_1")
    public void run_with_n_between_0_and_23() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 22);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("N1_2")
    public void run_with_n_smaller_than_0() {
        Mockito.when(this.console.read()).thenReturn(null);
        ohce = new OhceConsoleController(console, null, -1);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print("Time must be between 0 and 23.");
    }

    @Test
    @DisplayName("N1_2")
    public void run_with_n_bigger_than_23() {
        Mockito.when(this.console.read()).thenReturn(null);
        ohce = new OhceConsoleController(console, null, 24);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print("Time must be between 0 and 23.");
    }

    @Test
    @DisplayName("A_1 with 2 minim")
    public void run_with_minim_1() {
        Mockito.when(this.console.read()).thenReturn("o").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 2);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("o");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("A_1 with y maxim")
    public void run_with_maxim_y() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 3, 3);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }


    /**
     * Graf cauză efect ----Start----
     * ===========================================
     */

    @Test
    @DisplayName("(C1=1 || C2=0 || C3=0) && C5=1 -> Ef1")
    public void test_display_reverse_of_s1_in_effect_v1() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 7);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_MORNING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("(C1=0 || C2=1 || C3=0) && C5=1 -> Ef1")
    public void test_display_reverse_of_s1_in_effect1_v2() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 13);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_AFTERNOON + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("(C1=0 || C2=0 || C3=1) && C5=1 -> Ef1")
    public void test_display_reverse_of_s1_in_effect_v3() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 21);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C9=1 && C7=1 -> Ef2")
    public void test_string_2_will_modify() {
        Mockito.when(this.console.read()).thenReturn("Anita la gorda lagartona no traga la droga latina").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 21);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(5)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("anital agord al agart on anotragal adrog al atinA");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("g al atinAotragal adrona nord al agart oanital ag");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("(C1=1 || C2=0 || C3=0)-> Ef3")
    public void test_show_message_m1_on_start() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 7);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_MORNING + "Mihai!");
    }

    @Test
    @DisplayName("(C1=0 || C2=1 || C3=0)-> Ef3")
    public void test_show_message_m2_on_start() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 13);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_AFTERNOON + "Mihai!");
    }

    @Test
    @DisplayName("(C1=0 || C2=0 || C3=1)-> Ef3")
    public void test_show_message_m3_on_start() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 50, 21);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(4)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
    }

    @Test
    @DisplayName("(C4=1 || C6=0 || C13=0)-> Ef4")
    public void test_show_invalid_message_1() {
        Mockito.when(this.console.read()).thenReturn(null);
        ohce = new OhceConsoleController(console, null, -1);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print("Time must be between 0 and 23.");
    }

    @Test
    @DisplayName("(C4=0 || C6=1 || C13=0)-> Ef4")
    public void test_show_invalid_message_2() {
        Mockito.when(this.console.read()).thenReturn("natural").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 2, 1);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(2)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("Range of chat reached limits.");
    }

    @Test
    @DisplayName("(C4=0 || C6=0 || C13=1)-> Ef4")
    public void test_show_invalid_message_3() {
        Mockito.when(this.console.read()).thenReturn(null);
        ohce = new OhceConsoleController(console, -1, 1);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print("MaxChatLength must not be smaller than 0.");
    }

    @Test
    @DisplayName("C9 requires C5-> Ef5")
    public void test_show_palindrome() {
        Mockito.when(this.console.read()).thenReturn("oto").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 30, 2);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(5)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(2)).print("oto");
        Mockito.verify(this.console, Mockito.times(1)).print("¡Bonita palabra!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("C11 -> Ef6")
    public void test_end_execution() {
        Mockito.when(this.console.read()).thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 30, 3);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(0)).print("potS!");
        Mockito.verify(this.console, Mockito.times(2)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("Kill mutant: Changed conditional boundary to max length.")
    public void test_kill_mutant_max_length() {
        Mockito.when(this.console.read()).thenReturn("t").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 0, 1);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print("MaxChatLength must not be smaller than 0.");
    }

    @Test
    @DisplayName("Kill mutant: Changed conditional boundary to max time 0.")
    public void test_kill_mutant_n_boundary_0() {
        Mockito.when(this.console.read()).thenReturn("").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 20, 0);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(0)).print("Time must be between 0 and 23.");
    }

    @Test
    @DisplayName("Kill mutant: Changed conditional boundary to max time 23.")
    public void test_kill_mutant_n_boundary_23() {
        Mockito.when(this.console.read()).thenReturn("").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 20, 23);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(0)).print("Time must be between 0 and 23.");
    }

    @Test
    @DisplayName("Kill mutant: changed conditional boundary to limit Range. Greater chat length.")
    public void test_kill_mutant_inputChatLength_not_equal_2() {
        Mockito.when(this.console.read()).thenReturn("").thenReturn("ttttt").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 5, 23);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(2)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(0)).print("potS!");
        Mockito.verify(this.console, Mockito.times(0)).print("tttttt");
        Mockito.verify(this.console, Mockito.times(0)).print("Adios Mihai");
        Mockito.verify(this.console, Mockito.times(1)).print("Range of chat reached limits.");
    }

    @Test
    @DisplayName("Kill mutant: changed conditional boundary to limit Range. Greater chat length.")
    public void test_kill_mutant_inputChatLength_greater() {
        Mockito.when(this.console.read()).thenReturn("ototo").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 5, 23);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(0)).print("Range of chat reached limits.");
    }

    @Test
    @DisplayName("Kill not stopping program mutant.")
    public void test_stop_on_stop_chat() {
        Mockito.when(this.console.read()).thenReturn("Stop!").thenReturn("ttt");
        ohce = new OhceConsoleController(console, 1, 3);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(0)).print("potS!");
        Mockito.verify(this.console, Mockito.times(2)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("Adios Mihai");
    }

    @Test
    @DisplayName("Kill not stopping program mutant on throwing out of range.")
    public void test_stop_on_throw_out_of_range() {
        Mockito.when(this.console.read()).thenReturn("").thenReturn("Stop!");
        ohce = new OhceConsoleController(console, 1, 3);
        ohce.run("Mihai");
        Mockito.verify(this.console, Mockito.times(0)).print("potS!");
        Mockito.verify(this.console, Mockito.times(2)).print(Mockito.anyString());
        Mockito.verify(this.console, Mockito.times(1)).print(Greet.GREET_EVENING + "Mihai!");
        Mockito.verify(this.console, Mockito.times(1)).print("Range of chat reached limits.");
    }
}