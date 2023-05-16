package com.example.server.controllers;

import com.example.server.models.Player;
import com.example.server.services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayersController {

    private final PlayersService playersService;

    @Autowired
    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping(value="/players")
    public List<Player> getAllPlayers() {
        return playersService.getAllPlayers();
    }
}
