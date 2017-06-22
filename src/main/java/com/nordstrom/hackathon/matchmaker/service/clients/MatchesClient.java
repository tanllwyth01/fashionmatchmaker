package com.nordstrom.hackathon.matchmaker.service.clients;

import com.nordstrom.hackathon.matchmaker.service.models.Match;
import com.nordstrom.hackathon.matchmaker.service.models.Matches;
import org.springframework.stereotype.Component;

@Component
public class MatchesClient {

    public Matches getMatches(String username) {

        Matches matches = new Matches();
        matches.setUsername(username);

        Match match = new Match();
        match.setUsername("alice");
        match.setCorrelation(0.29f);
        matches.addMatch(match);

        match = new Match();
        match.setUsername("bob");
        match.setCorrelation(0.84f);
        matches.addMatch(match);

        return matches;

    }
}
