package cz.net21.ttulka.eval.bytesconsumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.apachecommons.CommonsLog;

@SpringBootApplication
@CommonsLog
public class StandaloneBytesConsumerApplication implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {        
        String pathToJar = System.getProperty("PATH_TO_JAR");
        
        log.info("StandaloneBytesConsumerApplication started: " + pathToJar);
        
        ProcessBuilder builder = new ProcessBuilder("java", "-jar", pathToJar);        
        try {
            Process process = builder.start();
            
            processErrors(process.getErrorStream());            
            processStream(process.getInputStream());            
                        
        } catch (Exception e) {
            log.error("Unexpected error.", e);
            System.exit(1);
        }
        System.exit(0);
    }
    
    private void processStream(InputStream stream) throws IOException {
        int b;
        while ((b = stream.read()) != -1) {
            // TODO do something with the stream
            System.out.print((byte)b);
        }
        stream.close();
    }
    
    private void processErrors(final InputStream in) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int logLevel = 3;   // 0 - ERROR, 1 - WARN, 2 - INFO, 3 - DEBUG
                Scanner scanner = new Scanner(in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("ERROR") || line.startsWith("FATAL")) {
                        logLevel = 0;
                    }
                    if (line.startsWith("WARN")) {
                        logLevel = 1;
                    }
                    if (line.startsWith("INFO")) {
                        logLevel = 2;
                    }
                    if (line.startsWith("DEBUG") || line.startsWith("TRACE")) {
                        logLevel = 3;
                    }
                    switch (logLevel) {
                        case 0:
                            log.error(line);
                            break;
                        case 1:
                            log.warn(line);
                            break;
                        case 2:
                            log.info(line);
                            break;
                        default:
                            log.debug(line);
                            break;
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StandaloneBytesConsumerApplication.class, args);
    }
}