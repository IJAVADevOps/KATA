package kata.imad.katanumbertostring.batch;
import kata.imad.katanumbertostring.*;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
public class NumbertToStringBatchExecution {

    private final JobLauncher jobLauncher;
    private final Job jobNumberToString;
    public NumbertToStringBatchExecution(final JobLauncher jobLauncher, final Job jobNumberToString) {
        this.jobLauncher = jobLauncher;
        this.jobNumberToString = jobNumberToString;
    }

    public void executeJob() throws Exception {
        jobLauncher.run(jobNumberToString, new JobParameters());
    }

}
