package com.nordstrom.hackathon.matchmaker.service.models;

public class Match {

    private String username;
    private float correlation;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getCorrelation() {
        return correlation;
    }

    public void setCorrelation(float correlation) {
        this.correlation = correlation;
    }
}
