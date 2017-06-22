package com.nordstrom.hackathon.matchmaker.service.clients;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.nordstrom.hackathon.matchmaker.service.models.Product;
import com.nordstrom.hackathon.matchmaker.service.models.Products;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class ProductClient {

    private final Gson gson = new GsonBuilder().create();

    public String getProductsJson() throws UnsupportedEncodingException {
        Products products = createProducts();
        return gson.toJson(products);

    }

    private Products createProducts() {
        String mongoHost = System.getProperty("mongo-host");
        String databaseName = System.getProperty("mongo-db");
        MongoClient mongoClient = new MongoClient(mongoHost);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> mongoProducts = mongoDatabase.getCollection("products");
        ObjectMapper mapper = new ObjectMapper();
        Products products = new Products();
        FindIterable<Document> productsFind = mongoProducts.find();
        try (MongoCursor<Document> curs = productsFind.iterator()) {
            while (curs.hasNext()) {
                Document doc = curs.next();
                String productJson = doc.toJson();
                Product product = mapper.readValue(productJson, Product.class);
                products.addProduct(product);
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
