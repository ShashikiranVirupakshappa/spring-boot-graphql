package com.javabro.controllers;

import com.javabro.model.Player;
import com.javabro.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @QueryMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
}
