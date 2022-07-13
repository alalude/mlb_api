package com.mlb.mlb_api.service;

import com.mlb.mlb_api.controllers.dto.PlayerDTO;
import com.mlb.mlb_api.repositories.PlayerRepository;
import com.mlb.mlb_api.repositories.entities.Player;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

    // NEXT V V V V V V V

    @Override
    public Player update(Integer id, PlayerDTO p) {

        Optional<Player> playerToUpdateOptional = playerRepository.findById(id);

        if (playerToUpdateOptional.isEmpty()) {
            return null;
        }

        Player playerToUpdate = playerToUpdateOptional.get();
        if (p.getAge() != null) {
            playerToUpdate.setAge(p.getAge());
        }

        if (p.getRating() != null) {
            playerToUpdate.setRating(p.getRating());
        }

        if (p.getName() != null) {
            playerToUpdate.setName(p.getName());
        }

        if (p.getYearsOfExperience() != null) {
            playerToUpdate.setYearsOfExperience(p.getYearsOfExperience());
        }

        return playerRepository.save(playerToUpdate);
    }

    @Override
    public void delete(Integer playerId) {

    }

    @Override
    public Iterable<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(Integer playerId) {

        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()){
            // throw an exception if the ID is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no player with the ID provided.");
        }
        return optionalPlayer.get();
    }

    @Override
    public Iterable<Player> findByName(String playerName) {

        List<Player> optionalPlayer = playerRepository.findByName(playerName);
        if(optionalPlayer.isEmpty()){
            // throw an exception if the name is invalid (my own addition)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no player by the name provided.");
        }
        return playerRepository.findByName(playerName);
    }
}
