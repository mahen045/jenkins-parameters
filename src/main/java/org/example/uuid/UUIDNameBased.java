/*
You can generate a UUID based on a namespace and a name.
 */
package org.example.uuid;
import java.util.UUID;

public class UUIDNameBased {
    public static void main(String[] args) {
        // Namespace and name
        UUID namespace = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        String name = "example.com";
        // Generate a UUID using the namespace and name (Version 3)
        UUID nameBasedUUID = UUID.nameUUIDFromBytes((namespace.toString() + name).getBytes());
        // Print the UUID
        System.out.println("Name-Based UUID: " + nameBasedUUID);
    }
}
