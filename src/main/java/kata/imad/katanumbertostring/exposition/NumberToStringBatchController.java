package kata.imad.katanumbertostring.exposition;

import kata.imad.katanumbertostring.batch.NumbertToStringBatchExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberToStringBatchController {

    private final NumbertToStringBatchExecution numbertoStringBatchExecution;
    @Autowired
    public NumberToStringBatchController(NumbertToStringBatchExecution numbertoStringBatchExecution) {
        this.numbertoStringBatchExecution = numbertoStringBatchExecution;
    }

    @GetMapping("/batchexecution")
    public ResponseEntity<String> getBatchExecution() {
        try {
            numbertoStringBatchExecution.executeJob();
            return ResponseEntity.ok("Batch execution completed");
        }catch (Exception e) {
            return ResponseEntity.status(500).body("Error executing batch"+e.getMessage());
        }
    }

}
