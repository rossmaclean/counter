package uk.co.rossmac.counter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class CounterApplication {

    private static long count = 0;

    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }

    @Scheduled(fixedRate = 2500)
    public void count() {
        log.info("Current count {}", count);
        count++;
    }

}
