package org.example.io;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class WriteToFile {
    public static void main(String[] args) {
        // File path
        String filePath = "output.txt";
        // Content to write to the file
        String content = "Hello, this is a demo of writing to a file using NIO Buffers and Channels!";
        try (FileOutputStream fos = new FileOutputStream(filePath);
             FileChannel fileChannel = fos.getChannel()) {
            // Create a ByteBuffer and put content into it
            ByteBuffer buffer = ByteBuffer.allocate(1024); // Allocate 1 KB buffer
            buffer.put(content.getBytes()); // Write data into the buffer
            buffer.flip(); // Prepare the buffer for writing to the channel
            // Write the buffer's data to the file
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
            System.out.println("File written successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
