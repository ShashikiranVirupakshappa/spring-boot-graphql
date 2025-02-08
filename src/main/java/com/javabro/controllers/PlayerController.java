package com.javabro.controllers;

import com.javabro.model.Player;
import com.javabro.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @QueryMapping
    public Player getPlayerById(@Argument Long id) {
        return playerService.getPlayerById(id).orElse(null);
    }

    @MutationMapping
    public Player createPlayer(@Argument Player player) {
        return playerService.addPlayer(player);
    }

    @MutationMapping
    public Player updatePlayer(@Argument Player player, @Argument Long id) {
        return playerService.updatePlayer(player, id);
    }

    @MutationMapping
    public Player deletePlayer(@Argument Long id) {
        return playerService.deletePlayer(id);
    }
}
