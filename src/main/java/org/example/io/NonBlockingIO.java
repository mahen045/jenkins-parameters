package org.example.io;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
public class NonBlockingIO {
    public static void main(String[] args) {
        String fileName = "data.txt";
        // Path to the file
        Path filePath = Path.of(fileName);
        // Open the file in non-blocking mode
        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ)) {
            // Allocate a buffer to hold file content
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // Read data into the buffer
            while (fileChannel.read(buffer) > 0) {
                buffer.flip(); // Prepare the buffer for reading
                // Print the content of the buffer as a string
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear(); // Clear the buffer for the next read
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
