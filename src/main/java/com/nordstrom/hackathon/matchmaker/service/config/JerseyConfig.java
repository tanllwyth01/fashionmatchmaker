package com.nordstrom.hackathon.matchmaker.service.config;

import com.nordstrom.hackathon.matchmaker.service.controllers.ResponseController;
import com.nordstrom.hackathon.matchmaker.service.filters.CorsResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class JerseyConfig extends ResourceConfig {

    @Autowired
    public JerseyConfig(Environment env) {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(ResponseController.class);
        register(CorsResponseFilter.class);
    }
}
