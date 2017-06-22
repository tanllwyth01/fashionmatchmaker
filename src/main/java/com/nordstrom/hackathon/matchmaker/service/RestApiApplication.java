package com.nordstrom.hackathon.matchmaker.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {

    /**
     * The main entrypoint for the RestApiApplication Spring Boot application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }
}
