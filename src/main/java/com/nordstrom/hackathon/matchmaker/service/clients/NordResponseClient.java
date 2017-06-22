package com.nordstrom.hackathon.matchmaker.service.clients;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.nordstrom.hackathon.matchmaker.service.models.NordResponse;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class NordResponseClient {

    public void addResponse(NordResponse nordResponse) {

        System.out.println(String.format("adding response %s", nordResponse.toString()));
        String mongoHost = System.getProperty("mongo-host");
        String databaseName = System.getProperty("mongo-db");
        MongoClient mongoClient = new MongoClient(mongoHost);
        Document document = new Document("username", nordResponse.getUsername())
                .append("productId", nordResponse.getProductId())
                .append("value", nordResponse.getValue());

        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);

        MongoCollection<Document> mongoResponses = mongoDatabase.getCollection("responses");
        mongoResponses.insertOne(document);
    }

    public void deleteUser(String username) {

        System.out.println("Deleting user : " + username);

    }
}
