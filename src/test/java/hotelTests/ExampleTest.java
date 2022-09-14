package hotelTests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {

    private static String userA = " Janusz";

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Dodaj uzytkownika A " + userA);
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("Usun uzytkownika A");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Zaloguj sie jako uzytkownik A " + userA);
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Wyloguj sie");
    }

    @Test
    public void test1(){
        System.out.println("Wyszukaj hotelu B");
        System.out.println("Zarezerwuj hotel B");
    }

    @Test
    public void test2() {
        System.out.println("Wyszukaj hotelu w terminie od X do Y");
        System.out.println("Zarezerwuj pierwszy hotel");
    }

    @Test
    public void testAssertions(){
        int expectedResult = 4;
        int actualResult = 2 + 2;
        assertEquals(expectedResult, actualResult, "Zakladamy ze 4 bedzie sie rownac 4");
    }
        }




