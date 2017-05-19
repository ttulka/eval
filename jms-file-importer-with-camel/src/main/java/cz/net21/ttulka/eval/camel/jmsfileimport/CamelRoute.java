package cz.net21.ttulka.eval.camel.jmsfileimport;

import java.nio.file.Path;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ttulka
 */
@Component
public class CamelRoute extends RouteBuilder {

    private final Path importFilesDir;

    public CamelRoute(@Value("${importFilesDir}") Path importFilesDir) {
        super();
        this.importFilesDir = importFilesDir;
    }

    @Override
    public void configure() {
        from("file:" + importFilesDir.toAbsolutePath() + "?delete=true&include=.*.json")
                .convertBodyTo(String.class)
                .to("jms:queue:importQueueCamel");
    }
}
