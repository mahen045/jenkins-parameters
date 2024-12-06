package org.example.io;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class ScatteringRead {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt");
             FileChannel channel = fis.getChannel()) {
            // Create multiple buffers
            ByteBuffer header = ByteBuffer.allocate(6); // For header
            ByteBuffer body = ByteBuffer.allocate(50);  // For body
            ByteBuffer[] buffers = {header, body};
            // Perform scattering read
            channel.read(buffers);
            // Flip buffers for reading
            header.flip();
            body.flip();
            System.out.println("Header: " + new String(header.array(), 0, header.limit()));
            System.out.println("Body: " + new String(body.array(), 0, body.limit()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
