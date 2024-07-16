package springAdvanced.startingLesson;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorParametrizedTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "{displayName} => {index} [{arguments}]")
    @ValueSource(strings = {"HELLO", "PDP", "FIND", "HIGH", "PAYED", "JOB"})
    @DisplayName("testMethod for Sum parametrized")
    void testMethod(String operation) {

        System.out.println(operation);
        Assertions.assertEquals(operation, operation.toUpperCase(Locale.ROOT));
    }


    @ParameterizedTest(name = "{displayName} => {index} [{arguments}]")
    @MethodSource("sumSource")
    void sum(SumArgument arg) {
        Assertions.assertEquals(arg.expected, calculator.sum(arg.a, arg.b));

    }

   /* @ParameterizedTest(name = "{displayName} => {index} [{arguments}]")
    @MethodSource
    void divide(DivArgument arg) {
        Assertions.assertEquals(arg.expected, calculator.divide(arg.a, arg.b));

    }*/

    static Stream<SumArgument> sumSource() {
        return Stream.of(
                new SumArgument(1, 2, 3),
                new SumArgument(-1, 13, 12),
                new SumArgument(16, -2, 14)
        );


    }

    public static class SumArgument {
        int a;
        int b;
        int expected;

        public SumArgument(int a, int b, int expected) {
            this.a = a;
            this.b = b;
            this.expected = expected;
        }

        @Override
        public String toString() {
            return "[a : %s, b : %s, expected : %s]"
                    .formatted(a, b, expected);
        }
    }

}