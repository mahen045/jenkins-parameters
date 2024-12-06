package org.example.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class InMemoryFileChannel {
    public static void main(String[] args) throws IOException {
        // Simulate an in-memory file using ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // Write data to the in-memory file
        try (WritableByteChannel writeChannel = Channels.newChannel(System.out)) {
            String data = "This is a test of in-memory file channel using Java NIO.";
            buffer.put(data.getBytes()); // Write data to the buffer
            buffer.flip(); // Prepare buffer for reading
            writeChannel.write(buffer); // Write buffer content to the output channel
        }
        // Read data back from the in-memory file
        buffer.flip(); // Reset the buffer to be read from the beginning
        try (ReadableByteChannel readChannel = Channels.newChannel(System.in)) {
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int bytesRead = readChannel.read(readBuffer); // Read from the simulated file
            while (bytesRead != -1) {
                readBuffer.flip(); // Prepare buffer for writing
                while (readBuffer.hasRemaining()) {
                    System.out.print((char) readBuffer.get()); // Print data
                }
                readBuffer.clear(); // Clear buffer for the next read
                bytesRead = readChannel.read(readBuffer);
            }
        }
    }
}
