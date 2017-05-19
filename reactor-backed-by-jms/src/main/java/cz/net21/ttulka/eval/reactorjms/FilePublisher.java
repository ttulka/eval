package cz.net21.ttulka.eval.reactorjms;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import static cz.net21.ttulka.eval.reactorjms.JmsConstants.IMPORT_QUEUE;

/**
 * Created by ttulka
 */
@SpringBootApplication
@EnableJms
// don't scan @FileImporter not to run its message listener @FileImporter.FileImporterListener
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = FileImporter.class)})
public class FilePublisher {

    @Autowired
    private JmsTemplate jmsTemplate;

    private void run() {
        new NewFilesWatcher(Paths.get("c:\\Develop\\data"), this::sendFile);
    }

    private void sendFile(String file) {
        jmsTemplate.convertAndSend(IMPORT_QUEUE, file);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FilePublisher.class, args);
        ctx.getBean(FilePublisher.class).run();
    }
}
