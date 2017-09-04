package cz.net21.ttulka.eval.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NIO Socket Client example.
 * <p>
 * Created by ttulka
 */
public class SocketClientExample {
    public void startClient() throws IOException, InterruptedException {
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8090);
        SocketChannel client = SocketChannel.open(hostAddress);

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "... started");

        // Send messages to server
        String[] messages = new String[]{threadName + ": test1", threadName + ": test2", threadName + ": test3"};
        for (int i = 0; i < messages.length; i++) {
            byte[] message = new String(messages[i]).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            client.write(buffer);
            System.out.println(messages[i]);
            buffer.clear();
            Thread.sleep(100);
        }
        client.close();
    }
}
