package kata.imad.katanumbertostring.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberToStringServiceTest {
    private NumberToStringService service;

    @BeforeEach
    void setUp() {
        service = new NumberToStringService();
    }
/*
    @Test
    void testDivisibilityRules() {
        assertEquals("FOOFOO", service.transformNumberToString(3));
        assertEquals("BARBAR", service.transformNumberToString(5));
        assertEquals("FOOBARBAR", service.transformNumberToString(15));
    }

    @Test
    void testContainsRules() {
        assertEquals("BARFOO", service.transformNumberToString(53));
        assertEquals("FOOFOOFOO", service.transformNumberToString(33));
        assertEquals("QUIX", service.transformNumberToString(7));
    }

    @Test
    void testSimpleNumbers() {
        assertEquals("1", service.transformNumberToString(1));
        assertEquals("2", service.transformNumberToString(2));
    }

    @Test
    void testInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, () -> service.transformNumberToString(-1));
        assertThrows(IllegalArgumentException.class, () -> service.transformNumberToString(101));
    }

 */
@ParameterizedTest
@CsvSource({
            "3, FOOFOO",
            "5, BARBAR",
            "15, FOOBARBAR",
            "53, BARFOO",
            "33, FOOFOOFOO",
            "7, QUIX",
            "27, FOOQUIX",
            "1, 1",
            "2, 2"
        })
    void testNumberTransformation(int input, String expected) {
        assertEquals(expected, service.transformNumberToString(input));
    }



    @ParameterizedTest
    @ValueSource(ints = {-1,0,100, 101, 1000})
    void testInvalidNumbers(int input) {
        assertThrows(IllegalArgumentException.class,
                () -> service.transformNumberToString(input));
    }

    @Test
    void testServiceNotNull() {
        assertNotNull(service);
    }
}
