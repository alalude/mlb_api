package com.mlb.mlb_api.service;

import com.mlb.mlb_api.controllers.dto.PlayerDTO;
import com.mlb.mlb_api.repositories.PlayerRepository;
import com.mlb.mlb_api.repositories.entities.Player;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(PlayerDTO playerDTO){
        Player player = new Player(playerDTO);
        return playerRepository.save(player);
    }

    @Override
    public Player update(PlayerDTO playerDTO) {
        return null;
    }

    @Override
    public void delete(Integer playerId) {

    }

    @Override
    public Iterable<Player> findAll() {
        return playerRepository.findAll();
    }

    // NEXT V V V V V V V
    @Override
    public Player findById(Integer playerId) {

        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()){
            return null;
        }
        return optionalPlayer.get();
    }
}
