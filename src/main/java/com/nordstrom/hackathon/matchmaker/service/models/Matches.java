package com.nordstrom.hackathon.matchmaker.service.models;

import java.util.ArrayList;
import java.util.List;

public class Matches {

    private String username;
    private List<Match> matches = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public void addMatch(Match match) {
        this.matches.add(match);
    }
}
