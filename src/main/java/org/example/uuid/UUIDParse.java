/*
You can create a UUID object from an existing UUID string.
 */
package org.example.uuid;
import java.util.UUID;
public class UUIDParse {
    public static void main(String[] args) {
        // Existing UUID string
        String uuidString = "550e8400-e29b-41d4-a716-446655440000";
        // Parse the UUID
        UUID uuid = UUID.fromString(uuidString);
        // Print the UUID
        System.out.println("Parsed UUID: " + uuid);
    }
}
