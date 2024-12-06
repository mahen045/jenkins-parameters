package org.example.io;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsyncFileWithCompletionHandler {
    public static void main(String[] args) {
        Path path = Path.of("async_write.txt");

        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                path, StandardOpenOption.READ)) {

            // Buffer to hold data
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read data asynchronously
            Future<Integer> result = fileChannel.read(buffer, 0);

            // Do something else while the read operation completes
            System.out.println("Reading file asynchronously...");

            // Block until the read is done
            int bytesRead = result.get();
            buffer.flip(); // Prepare buffer for reading
            byte[] data = new byte[bytesRead];
            buffer.get(data);

            System.out.println("File content: " + new String(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
