package org.example.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SaveProperties {
    public static void main(String[] args) {
        Properties appProps = new Properties();

        // Set properties
        appProps.setProperty("app.name", "MyApp");
        appProps.setProperty("app.version", "1.0.0");
        appProps.setProperty("app.author", "John Doe");

        try (FileOutputStream fos = new FileOutputStream("config.properties")) {
            // Save properties to a file
            appProps.store(fos, "Application Configuration");
            System.out.println("Properties saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
