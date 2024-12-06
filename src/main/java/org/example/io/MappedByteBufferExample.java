package org.example.io;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
public class MappedByteBufferExample {
    public static void main(String[] args) {
        // File path
        String filePath = "largefile.txt";
        // Size of data to map
        int mapSize = 1024 * 1024; // 1 MB
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
             FileChannel channel = file.getChannel()) {
            // Map a portion of the file into memory (read-write mode)
            MappedByteBuffer mappedBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, mapSize);
            // Write data into the mapped region
            String data = "This is data written to the memory-mapped file.";
            mappedBuffer.put(data.getBytes());

            // Read back the data from the mapped buffer
            mappedBuffer.position(0); // Reset position to read from the beginning
            byte[] bytes = new byte[data.length()];
            mappedBuffer.get(bytes);
            System.out.println("Data read from file: " + new String(bytes));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
