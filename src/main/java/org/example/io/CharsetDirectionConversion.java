package org.example.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetDirectionConversion {
    public static void main(String[] args) {
        // Text to convert
        String text = "Hello, Charset Conversion!";
        // Charset instance
        Charset charset = StandardCharsets.UTF_8;
        // Encode: CharBuffer to ByteBuffer
        ByteBuffer byteBuffer = charset.encode(text);
        // Decode: ByteBuffer to CharBuffer
        CharBuffer charBuffer = charset.decode(byteBuffer);
        // Display results
        System.out.println("Original Text: " + text);
        System.out.println("Encoded ByteBuffer: " + new String(byteBuffer.array(), charset));
        System.out.println("Decoded CharBuffer: " + charBuffer.toString());
    }
}
