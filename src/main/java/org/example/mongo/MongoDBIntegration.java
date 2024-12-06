package org.example.mongo;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.Arrays;
public class MongoDBIntegration {
    public static void main(String[] args) {
        // Connection String to MongoDB
        String mongoHost = "localhost";
        int mongoPort = 27017;
        String databaseName = "testDatabase";
        // Create a MongoClient instance
        try (MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(mongoHost, mongoPort))))
                        .build())) {

            // Access the database
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            System.out.println("Connected to database: " + databaseName);
            // Access or create a collection
            MongoCollection<Document> collection = database.getCollection("testCollection");
            // Insert a document
            Document document = new Document("name", "John Doe")
                    .append("age", 29)
                    .append("city", "New York");
            collection.insertOne(document);
            System.out.println("Inserted document: " + document.toJson());
            // Retrieve documents
            System.out.println("Fetching all documents:");
            FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }

            // Update a document
            Document query = new Document("name", "John Doe");
            Document update = new Document("$set", new Document("age", 30));
            collection.updateOne(query, update);
            System.out.println("Updated document with name 'John Doe'");

            // Delete a document
           // collection.deleteOne(query);
            //System.out.println("Deleted document with name 'John Doe'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
