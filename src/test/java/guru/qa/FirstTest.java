package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

public class FirstTest {
    @BeforeAll
    static void beforeAll() {
        //Configuration.browser = "chrome";
        System.out.println("            beforeAll");

    }
    @AfterAll
    static void afterAll() {
        System.out.println("            afterAll");

    }
    @BeforeEach
    void BeforeEach() {
       System.out.println("            BeforeEach");

    }
    @AfterEach
    void AfterEach() {
        System.out.println("            AfterEach");

    }

    @Test
    void firstTest() {
        System.out.println("            firstTest");
        Assertions.assertTrue(3>2);
    }
    @Test
    void secondTest() {
        System.out.println("            secondTest");
        Assertions.assertTrue(3>2);
    }
    @Test
    void thirdTest() {
        System.out.println("            thirdTest");
        Assertions.assertTrue(3>2);
    }
}
