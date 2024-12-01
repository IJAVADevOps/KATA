package kata.imad.katanumbertostring.exposition;

import kata.imad.katanumbertostring.domain.NumberToStringService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class NumberToStringControllerTest {

    @Mock
    private NumberToStringService numberToStringService;

    @InjectMocks
    private NumberToStringController numberToStringController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(numberToStringController).build();
    }

    @Test
    void testNumberToString_Success()  {
        int number = 15;
        String expected = "FOOBAR";

        when(numberToStringService.transformNumberToString(number)).thenReturn(expected);

        ResponseEntity<String> response = numberToStringController.numberToString(number);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testNumberToString_Failure() {

        int number = -1;
        String expectedMessage = "le nombre doit etre entre 0 et 100";
        when(numberToStringService.transformNumberToString(number)).thenThrow(new IllegalArgumentException(expectedMessage));

        ResponseEntity<String> response = numberToStringController.numberToString(number);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals(expectedMessage, response.getBody());
    }

    @Test
    void testNumberToString_ValidNumber() throws Exception {

        int number = 7;
        String expectedResult = "7";
        when(numberToStringService.transformNumberToString(number)).thenReturn(expectedResult);

        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/api/transform/{number}", number))
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isOk())
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.content().string(expectedResult));
    }

    @Test
    void testNumberToString_InvalidNumber() throws Exception {
        int number = 150;
        String expectedMessage = "le nombre doit etre entre 0 et 100";
        when(numberToStringService.transformNumberToString(number)).thenThrow(new IllegalArgumentException(expectedMessage));

        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/api/transform/{number}", number))
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isBadRequest())
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.content().string(expectedMessage));
    }


}
