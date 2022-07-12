package com.mlb.mlb_api.service;

import com.mlb.mlb_api.controllers.dto.PlayerDTO;
import com.mlb.mlb_api.repositories.entities.Player;

public interface PlayerService {
    Player save(PlayerDTO playerDTO);
    Player update(PlayerDTO playerDTO);
    void delete(Integer playerId);
    // NEXT V V V V V V V
    Iterable<Player> findAll();
    Player findById(Integer playerId);
}
