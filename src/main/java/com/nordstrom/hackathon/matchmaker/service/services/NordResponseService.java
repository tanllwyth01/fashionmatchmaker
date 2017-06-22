package com.nordstrom.hackathon.matchmaker.service.services;

import com.nordstrom.hackathon.matchmaker.service.clients.NordResponseClient;
import com.nordstrom.hackathon.matchmaker.service.models.NordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NordResponseService {

    private NordResponseClient nordResponseClient;

    @Autowired
    public NordResponseService(NordResponseClient nordResponseClient) {
        this.nordResponseClient = nordResponseClient;
    }

    public void addResponse(NordResponse nordResponse) {

        nordResponseClient.addResponse(nordResponse);

    }

    public void deleteUser(String username) {

        nordResponseClient.deleteUser(username);
    }

}
