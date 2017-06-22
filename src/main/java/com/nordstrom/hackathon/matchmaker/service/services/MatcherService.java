package com.nordstrom.hackathon.matchmaker.service.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nordstrom.hackathon.matchmaker.service.clients.MatchesClient;
import com.nordstrom.hackathon.matchmaker.service.models.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatcherService {

    private final Gson gson = new GsonBuilder().create();
    private MatchesClient matchesClient;

    @Autowired
    public MatcherService(MatchesClient matchesClient){
        this.matchesClient = matchesClient;
    }

    public String getMatchesJson(String username) {

        Matches matches = matchesClient.getMatches(username);
        return gson.toJson(matches);

    }
}
