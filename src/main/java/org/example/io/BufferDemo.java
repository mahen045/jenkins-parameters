package org.example.io;

import java.nio.ByteBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // Initial state
        System.out.println("Initial State:");
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit: " + buffer.limit());

        // Write data
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        System.out.println("\nAfter Writing Data:");
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit: " + buffer.limit());

        // Flip for reading
        buffer.flip();
        System.out.println("\nAfter Flipping:");
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit: " + buffer.limit());

        // Read data
        System.out.println("\nReading Data:");
        while (buffer.hasRemaining()) {
            System.out.println("Value: " + buffer.get());
        }

        // Clear the buffer
        buffer.clear();
        System.out.println("\nAfter Clearing:");
        System.out.println("Position: " + buffer.position());
        System.out.println("Limit: " + buffer.limit());
    }

}
