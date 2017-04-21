package cz.net21.ttulka.io;

import java.io.*;
import java.util.Date;
import java.util.Random;

/**
 * Write random strings into a file with flushing.
 *
 * Created by ttulka
 */
public class WriteWithFlush {

    public static void main(String[] argv) throws Exception {
        WriteWithFlush main = new WriteWithFlush();

        int size = main.readSizeFromConsole();

        System.out.println("Writing...");
        Thread t = new Thread(() -> main.write(size));
        t.start();
        t.join();
    }

    private void write(int sizeInKb) {
        try(PrintWriter writer = new PrintWriter("output.dat", "UTF-8")) {
            new Random(new Date().getTime())
                    .longs(sizeInKb * 1024)
                    .map(n -> n % 10)
                    .map(Math::abs)
                    .mapToObj(String::valueOf)
                    .forEach(writer::print);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int readSizeFromConsole() {
        int size = 0;

        final Console console = System.console();
        while (size <= 0) {
            String sizeStr = console.readLine("Size of the output file (KB): ");
            try {
                size = Integer.parseInt(sizeStr);
            } catch (Exception e) {
                size = 0;
            }
        }
        return size;
    }
}


