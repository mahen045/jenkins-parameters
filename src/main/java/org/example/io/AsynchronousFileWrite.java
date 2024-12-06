package org.example.io;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileWrite {
    public static void main(String[] args) {
        Path path = Path.of("async_write.txt");

        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            // Data to write
            String data = "Hello, Asynchronous FileChannel!";
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());

            // Write data asynchronously
            Future<Integer> result = fileChannel.write(buffer, 0);

            // Do something else while the write operation completes
            System.out.println("Writing to file asynchronously...");

            // Block until the write is done
            int bytesWritten = result.get();
            System.out.println("Bytes written: " + bytesWritten);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
