package springAdvanced.startingLesson;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Logger;

@Nested
@DisplayName("TEst class for calculator")
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.Random.class) //  this is for ordering of methods
public class CalculatorTest {

    Calculator calculator;
    private static final Logger logger = Logger.getLogger(CalculatorTest.class.getName());

    @BeforeEach
//  set up should be executed before all the tests in the class
    void setUp() {
        logger.info("@BeforeEach(SetUp method is working)");
        calculator = new Calculator(); // 1
    }

    @AfterEach
    void tearDown() {
        logger.info("@AfterEach(tearDown method is working)");
    }

    @BeforeAll // calls once before all the tests
    static void setUpAll() {
        logger.info("@BeforeAll(SetUp method is working)");
    }

    @AfterAll
    static void tearDownAll() {
        logger.info("@AfterAll(SetUp method is working)");

    }

    @Test
    @DisplayName("Test for sum method")
    void test_for_sum_method() {
        //Calculator calculator = new Calculator(); // set up
        logger.info("@testForSum(testForSum method is working)");
        int expected = 5;
        int actual = calculator.sum(2, 3); // execution which means calling an objects method which we created for testing purpose
        Assertions.assertEquals(expected, actual); // Assertions which means checking we expect a value then we check it is equal result that we expected
    }

    @Test
    @Order(1)
        // or we can use order annotation to order method
    void test_for_div_method() {
        //Calculator calculator = new Calculator(); // set up
        logger.info("@Test(testForDiv method is working)");
        int expected = 5;
        int actual = calculator.divide(10, 2); // execution which means calling an objects method which we created for testing purpose
        Assertions.assertEquals(expected, actual); // Assertions which means checking we expect a value then we check it is equal result that we expected
    }

    @Test
    @DisplayName("Test For Div Method which throws exception")
    void test_for_div_method_which_throws_exception() {
//        ArithmeticException e = Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10, 1));
//        e.printStackTrace();
    }

    @Test
    @DisplayName("Test For Div Method which has timeout")
    void test_for_div_method_which_has_timeOut() {
//        ArithmeticException e = Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        Assertions.assertTimeout(Duration.ofMillis(500), () -> calculator.divide(10, -2));
    }

    @Test
    @Disabled("this test method disabled due to checking @Disabled annotations")
    void ignored() {
    }

    @Test
    @EnabledIf(value = "testCondition", disabledReason = "@EnabledIf is checking....")
    void enabledIfMethod() {
    }

    @Test     //value = "testCondition" shunga boshqa methoddi call qvomman testCondition dgan undan true/false qaytadi
    @DisabledIf(value = "testCondition", disabledReason = "Testing @DisabledIf annotation")
    void disabledWithCondition() {
    }

    boolean testCondition() {
        return new Random().nextBoolean();
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void shouldWorkOnOnlyWithWindowsOs() {
    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    void shouldWorkOnOnlyWithWindowsOrLinuxOnly() {
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void shouldNotWorkOnOnlyWithWindowsOs() {
    }

    @Test
    @DisabledOnOs({OS.WINDOWS, OS.LINUX})
    void shouldNotWorkOnOnlyWithWindowsOrLinuxOnly() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void should_work_onJRE_8_0nly() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void should_not_work_onJRE_8_0nly() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_18)
    void should_not_work_on_between_JRE_8_20() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_18)
    void should_work_on_between_JRE_8_20() {
    }

}


