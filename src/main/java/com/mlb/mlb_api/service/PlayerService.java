package com.mlb.mlb_api.service;

import com.mlb.mlb_api.controllers.dto.PlayerDTO;
import com.mlb.mlb_api.repositories.entities.Player;

public interface PlayerService {
    Player save(PlayerDTO playerDTO);
    // NEXT V V V V V V V
    Player update(Integer playerId, PlayerDTO playerDTO); // I added playerId parameter
    void delete(Integer playerId);
    Iterable<Player> findAll();
    Player findById(Integer playerId);
    Iterable<Player> findByName(String playerName);
}
