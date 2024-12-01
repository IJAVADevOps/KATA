package kata.imad.katanumbertostring.exposition;

import kata.imad.katanumbertostring.domain.NumberToStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transform")
public class NumberToStringController {

    private final NumberToStringService numberToStringService;

    @Autowired
    public NumberToStringController(NumberToStringService numberToStringService) {
        this.numberToStringService = numberToStringService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<String> numberToString(@PathVariable int number) {

        try {
            String result = numberToStringService.transformNumberToString(number);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
