/*
CompletionHandler interface provides a callback-based
approach to handle the result of an asynchronous operation.
This is more suitable for non-blocking, event-driven applications.
 */
package org.example.io;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AsyncReadWithCompletionHandler {
    public static void main(String[] args) {
        Path filePath = Path.of("example_completion_handler.txt");

        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                filePath, StandardOpenOption.READ)) {

            // Allocate a buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Initiate asynchronous read with a CompletionHandler
            fileChannel.read(buffer, 0, null, new CompletionHandler<>() {
                @Override
                public void completed(Integer bytesRead, Object attachment) {
                    buffer.flip(); // Prepare buffer for reading
                    byte[] data = new byte[bytesRead];
                    buffer.get(data);
                    System.out.println("File content: " + new String(data));
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.err.println("Read operation failed!");
                    exc.printStackTrace();
                }
            });

            // Perform other tasks while the read operation is in progress
            System.out.println("Reading file asynchronously using CompletionHandler...");

            // Ensure the main thread stays alive to see the asynchronous operation's result
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
