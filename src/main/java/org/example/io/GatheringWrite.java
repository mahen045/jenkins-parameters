package org.example.io;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class GatheringWrite {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output1.txt");
             FileChannel channel = fos.getChannel()) {
            // Create multiple buffers
            ByteBuffer header = ByteBuffer.allocate(11);
            ByteBuffer body = ByteBuffer.allocate(50);
            // Fill buffers with data
            header.put("HeaderData ".getBytes());
            body.put("This is the body of the file.".getBytes());
            // Flip buffers for writing
            header.flip();
            body.flip();
            // Perform gathering write
            ByteBuffer[] buffers = {header, body};
            channel.write(buffers);
            System.out.println("Data written to file using gathering write.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
