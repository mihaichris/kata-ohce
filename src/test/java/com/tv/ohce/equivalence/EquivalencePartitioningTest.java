package com.tv.ohce.equivalence;

import com.tv.ohce.controller.OhceConsoleController;
import com.tv.ohce.greet.Greet;
import infrastructure.console.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mock;
import org.mockito.Mockito;

public class EquivalencePartitioningTest {

    private OhceConsoleController ohce;

    @Mock
    private Console console;

    @BeforeEach
    @Timeout(4)
    public void setUp() {
        this.console = Mockito.mock(Console.class);
    }

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
        Mockito.verify(this.console, Mockito.times(1)).print("Max chat length must not be smaller than 0.");
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
     * Boundary Values ----Start----
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
}
