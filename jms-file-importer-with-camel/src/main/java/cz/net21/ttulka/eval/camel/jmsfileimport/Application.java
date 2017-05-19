package cz.net21.ttulka.eval.camel.jmsfileimport;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ttulka
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        try {
            System.in.read();
        } catch (IOException e) {
        }
    }
}
