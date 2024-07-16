package springAdvanced.startingLesson;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRepeatedTest {

    Calculator calculator;
    Random random;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        random = new Random();
    }

    @AfterEach
    void tearDown() {
    }

    @RepeatedTest(value = 10, name = "{displayName}")
    @DisplayName("test for sum repeated")
    void sum() {
        int a = random.nextInt(11) + 20; // Generates a number between 20 (inclusive) and 30 (exclusive)
        int b = random.nextInt(8) + 4;   // Generates a number between 4 (inclusive) and 12 (exclusive)
        int expected = a + b;
        Assertions.assertEquals(expected, calculator.sum(a, b));
    }

    @RepeatedTest(value = 10, name = "{displayName}")
    @DisplayName("test for sum repeated")
    void divide() {
        int a = random.nextInt(11) + 20; // Generates a number between 20 (inclusive) and 30 (exclusive)
        int b = random.nextInt(8) + 4;   // Generates a number between 4 (inclusive) and 12 (exclusive)
        int expected = a / b;
        Assertions.assertEquals(expected, calculator.divide( a, b));
    }
}