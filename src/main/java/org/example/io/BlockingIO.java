package org.example.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class BlockingIO {
    public static void main(String args[]) throws IOException {
        String fileName = "data.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read lines one by one
            while ((line = reader.readLine()) != null) {
                // Blocking call - waits until a line is read
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
 }

