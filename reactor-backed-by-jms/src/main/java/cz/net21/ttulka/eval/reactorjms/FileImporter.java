package cz.net21.ttulka.eval.reactorjms;

import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

import static cz.net21.ttulka.eval.reactorjms.JmsConstants.IMPORT_QUEUE;

/**
 * Created by ttulka
 */
@SpringBootApplication
@EnableJms
public class FileImporter {

    @Autowired
    private FileImporterListener busListener;

    Flux<String> publisher() {
        return Flux.from(subscriber -> busListener.setSubscriber(subscriber));
    }

    private void run() {
        publisher().subscribe(file -> System.out.println("Import file " + file));
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FileImporter.class, args);
        ctx.getBean(FileImporter.class).run();
    }

    @Component
    private class FileImporterListener {

        private Subscriber<? super String> subscriber;

        public void setSubscriber(Subscriber<? super String> subscriber) {
            this.subscriber = subscriber;
        }

        @JmsListener(destination = IMPORT_QUEUE)
        public void onNewFile(String file) {
            if (subscriber != null) {
                try {
                    subscriber.onNext(file);
                } catch (Exception e) {
                    subscriber.onError(new RuntimeException(e));
                }
            }
        }
    }
}
