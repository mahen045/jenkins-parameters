package org.example.io;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
public class ByteBufferToCharBuffer {
    public static void main(String[] args) {
        // Step 1: Create a ByteBuffer with text data in UTF-8 encoding
        String text = "Hello, Java NIO!";
        ByteBuffer byteBuffer = ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8));

        // Step 2: Decode the ByteBuffer into a CharBuffer
        Charset charset = StandardCharsets.UTF_8; // Specify the charset
        CharBuffer charBuffer = charset.decode(byteBuffer);

        // Step 3: Use the CharBuffer
        System.out.println("Decoded CharBuffer content: " + charBuffer.toString());

        // Reverse: Encode the CharBuffer back to a ByteBuffer
        byteBuffer = charset.encode(charBuffer);
        System.out.println("Encoded ByteBuffer content: " + new String(byteBuffer.array(), StandardCharsets.UTF_8));
    }
}
