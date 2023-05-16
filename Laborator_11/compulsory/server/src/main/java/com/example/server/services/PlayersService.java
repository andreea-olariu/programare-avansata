package com.example.server.services;

import com.example.server.models.Player;
import com.example.server.repositories.PlayersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {
    private final PlayersRepository playersRepository;

    public PlayersService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public List<Player> getAllPlayers() {
        return playersRepository.findAll();
    }

}
