package cz.net21.ttulka.eval.bytesproducer;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.apachecommons.CommonsLog;

@SpringBootApplication
@CommonsLog
public class StandaloneBytesProducerApplication implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        log.info("StandaloneBytesProducerApplication started.");
        try {
            int bytesAmount = 1000;
            if (args.containsOption("bytes")) {
                bytesAmount = Integer.parseInt(args.getOptionValues("bytes").get(0));   
            }
            
            for (int i = 0; i < bytesAmount; i++) {    
                System.out.write(i % Byte.MAX_VALUE);   // we're writing on the standard output stream
            }
                        
        } catch (Exception e) {
            log.error("Unexpected error.", e);
            System.exit(1);
        }
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StandaloneBytesProducerApplication.class, args);
    }
}