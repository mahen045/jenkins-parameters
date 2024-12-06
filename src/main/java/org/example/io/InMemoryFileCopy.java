package org.example.io;

import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class InMemoryFileCopy {
    public static void main(String[] args) throws Exception {
        // Simulate source data
        ByteBuffer sourceBuffer = ByteBuffer.allocate(1024);
        String data = "Simulating a file copy operation using in-memory channels.";
        sourceBuffer.put(data.getBytes());
        sourceBuffer.flip();

        // Create ReadableByteChannel for source
        ReadableByteChannel sourceChannel = Channels.newChannel(System.in);

        // Create a target buffer
        ByteBuffer targetBuffer = ByteBuffer.allocate(1024);

        // Create WritableByteChannel for target
        WritableByteChannel targetChannel = Channels.newChannel(System.out);

        // Perform copy
        while (sourceBuffer.hasRemaining()) {
            targetBuffer.put(sourceBuffer.get());
        }

        // Flip the target buffer and write to the target channel
        targetBuffer.flip();
        targetChannel.write(targetBuffer);

        System.out.println("\nCopy completed.");
    }
}
