package cz.net21.ttulka.eval.logging;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.logging.log4j.core.LogEventListener;
import org.apache.logging.log4j.core.net.server.InputStreamLogEventBridge;
import org.apache.logging.log4j.core.net.server.JsonInputStreamLogEventBridge;
import org.junit.Test;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class Log4j2ApplicationTest {

    private final LogEventListener logEventListener = new Log4j2EventListener();
    private final InputStreamLogEventBridge logEventBridge = new JsonInputStreamLogEventBridge();

    @Test
    public void test() throws Exception {
        log.info("Test started.");

        String workingDir = new File(".").getAbsolutePath();

        ProcessBuilder builder = new ProcessBuilder(
                "java",
                "-Dlog4j.configurationFile=" + workingDir + "\\src\\test\\resources\\log4j2.xml",
                "-DexternalProcess=true",
                "-jar",
                workingDir + "\\target\\log4j2-events-1.0.jar"
        );
        System.out.println("CMD: " + builder.command());

        Process process = builder.start();

        processLogEvents(process.getErrorStream());

        processStream(process.getInputStream());
        process.waitFor();

        log.info("Test finished.");
    }

    private void processLogEvents(final InputStream in) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logEventBridge.logEvents(in, logEventListener);

                } catch (Exception e) {
                    log.error("Error by processing log events.", e);
                }
            }
        }).start();
    }

    private void processStream(final InputStream in) {
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line != null && !line.isEmpty()) {
                    System.out.println(line);
                }
            }
        }
    }

    private class Log4j2EventListener extends LogEventListener {
    }
}
