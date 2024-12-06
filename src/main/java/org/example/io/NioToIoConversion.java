package org.example.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioToIoConversion {
    public static void main(String[] args) throws IOException {
        // File path
        Path filePath = Paths.get("example.txt");
        // Write some data to the file using OutputStream
        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
             OutputStream outputStream = Channels.newOutputStream(fileChannel)) {
            String data = "Hello, Java NIO and IO!";
            outputStream.write(data.getBytes());
        }
        // Read the file data using InputStream
        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ);
             InputStream inputStream = Channels.newInputStream(fileChannel)) {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String content = new String(buffer, 0, bytesRead);
            System.out.println("File Content: " + content);
        }
    }
}
