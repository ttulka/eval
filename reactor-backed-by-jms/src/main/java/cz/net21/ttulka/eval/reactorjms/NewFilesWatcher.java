package cz.net21.ttulka.eval.reactorjms;

import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.function.Consumer;

import lombok.extern.apachecommons.CommonsLog;

/**
 * Created by ttulka
 */
@CommonsLog
public class NewFilesWatcher {

    private final Path dir;
    private final Consumer<String> consumer;

    public NewFilesWatcher(Path dir, Consumer<String> consumer) {
        this.dir = dir;
        this.consumer = consumer;

        watch();
    }

    private void watch() {
        try {
            WatchKey watchKey;
            do {
                WatchService watcher = dir.getFileSystem().newWatchService();
                dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
    
                watchKey = watcher.take();
                watchKey.pollEvents()
                        .stream()
                        .map(event -> (Path) event.context())
                        .map(Path::toAbsolutePath)
                        .map(Path::toString)
                        .forEach(consumer::accept);

            } while(watchKey.reset());
        } catch (Exception e) {
            log.warn("Exception by watching a directory: " + dir, e);
        }
    }
}
