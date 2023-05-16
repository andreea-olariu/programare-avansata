package com.example.server.repositories;

import com.example.server.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayersRepository extends JpaRepository<Player, UUID> {
}
