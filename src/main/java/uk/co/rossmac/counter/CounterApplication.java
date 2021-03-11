package uk.co.rossmac.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@RestController
@RequestMapping("/api")
public class CounterApplication {

    private static final Logger log = LoggerFactory.getLogger(CounterApplication.class);

    private static long count = 0;

    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }

    @Scheduled(fixedRate = 2000)
    public void count() {
        log.info("Current count " + count);
        if (count % 5 == 0) {
            log.error("This is an error, count is " + count);
        }
        count++;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/count")
    public long getCount() {
        return count;
    }

}
