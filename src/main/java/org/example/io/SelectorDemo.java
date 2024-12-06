package org.example.io;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        // Create a selector
        Selector selector = Selector.open();
        // Create a server socket channel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false); // Set non-blocking mode
        serverChannel.bind(new InetSocketAddress(8080)); // Bind to port 8080
        // Register the server channel with the selector for ACCEPT events
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server started on port 8080. Waiting for clients...");
        while (true) {
            // Wait for an event (blocking with timeout of 1 second)
            if (selector.select(1000) == 0) {
                System.out.println("Waiting for events...");
                continue;
            }
            // Get the set of ready keys
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // Handle new client connections
                if (key.isAcceptable()) {
                    handleAccept(key, selector);
                }
                // Handle read events
                if (key.isReadable()) {
                    handleRead(key);
                }
                // Remove the processed key
                iterator.remove();
            }
        }
    }
    private static void handleAccept(SelectionKey key, Selector selector) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept(); // Accept the connection
        clientChannel.configureBlocking(false); // Set non-blocking mode
        // Register the new client channel with the selector for READ events
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("Accepted connection from: " + clientChannel.getRemoteAddress());
    }
    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        int bytesRead = clientChannel.read(buffer); // Read data from client
        if (bytesRead == -1) {
            // Client has closed the connection
            System.out.println("Client disconnected: " + clientChannel.getRemoteAddress());
            clientChannel.close();
            key.cancel();
            return;
        }
        buffer.flip(); // Prepare buffer for reading
        String message = new String(buffer.array(), 0, buffer.limit());
        System.out.println("Received message: " + message);
        // Echo the message back to the client
        //buffer.rewind(); // Reuse the buffer
       // clientChannel.write(buffer);
    }
}
