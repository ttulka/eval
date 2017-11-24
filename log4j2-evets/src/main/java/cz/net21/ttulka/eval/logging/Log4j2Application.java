package cz.net21.ttulka.eval.logging;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class Log4j2Application {

    public static void main(String[] args) {

        log.fatal("FATAL message");
        log.error("ERROR message");
        log.warn("WARN message");
        log.info("INFO message");
        log.debug("DEBUG message");
        log.trace("TRACE message");
    }
}
