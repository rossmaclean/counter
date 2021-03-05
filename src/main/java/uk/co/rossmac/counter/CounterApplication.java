package uk.co.rossmac.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class CounterApplication {

    private static final Logger log = LoggerFactory.getLogger(  CounterApplication.class);

    private static long count = 0;

    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }

    @Scheduled(fixedRate = 1000)
    public void count() {
        log.info("Current count " + count);
        if (count % 2 == 0) {
            log.error("This is an error, count is " + count);
        }
        count++;
    }

}
