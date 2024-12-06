/*
The Future API allows you to initiate an asynchronous operation
and then either poll for the result or block until the operation completes.
 */
package org.example.io;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsyncReadWithFuture {
    public static void main(String[] args) {
        Path filePath = Path.of("example_future.txt");

        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                filePath, StandardOpenOption.READ)) {

            // Allocate a buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Initiate asynchronous read
            Future<Integer> future = fileChannel.read(buffer, 0);

            // Do some other work while reading is in progress
            System.out.println("Reading file asynchronously...");

            // Wait for the read operation to complete
            int bytesRead = future.get(); // This blocks until the read is complete
            buffer.flip(); // Prepare buffer for reading

            // Process the read data
            byte[] data = new byte[bytesRead];
            buffer.get(data);
            System.out.println("File content: " + new String(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
