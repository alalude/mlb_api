package com.mlb.mlb_api.controllers;

import com.mlb.mlb_api.controllers.dto.PlayerDTO;
import com.mlb.mlb_api.repositories.entities.Player;
import com.mlb.mlb_api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired // this annotation is not needed
//    Old way - before Service
//    private final PlayerRepository playerRepository;

//    public PlayerController(final PlayerRepository playerRepository) {
//        this.playerRepository = playerRepository;
//    }

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

//    Old way - before Service
//    @PostMapping("/add")
//    public Player createNewPlayer(@RequestBody Player player) {
//        return playerRepository.save(player);
//    }

    @PostMapping("/add")
    public Player createNewPlayer(@RequestBody PlayerDTO newPlayerDTO) {
        return playerService.save(newPlayerDTO);
    }

    @GetMapping
    public Iterable<Player> getPlayer(){
        return playerService.findAll();
    }

    // ------------------------------------------------------------------------

//    @GetMapping("/{id}")
//    public Player getPlayerById(@PathVariable("id") Integer id){
//
//        Optional<Player> optionalPlayer = playerRepository.findById(id);
//        if(optionalPlayer.isEmpty()){
//            return null;
//        }
//        return optionalPlayer.get();
//    }
//
//    @GetMapping("/name/{name}")
//    public Iterable<Player> getPlayerByName(@PathVariable("name") String name){
//
//        System.out.println(name);
//
////        List<Player> optionalPlayer = playerRepository.findByName(name);
////        if(optionalPlayer.isEmpty()){
////            return null;
////        }
////        return optionalPlayer;
//
//        return playerRepository.findByName(name);
//    }
//
//    @PutMapping("/{id}")
//    public Player updatePlayer(
//            @PathVariable("id") Integer id,
//            @RequestBody Player p
//    ) {
//        Optional<Player> playerToUpdateOptional = playerRepository.findById(id);
//        if (playerToUpdateOptional.isEmpty()) {
//            return null;
//        }
//        Player playerToUpdate = playerToUpdateOptional.get();
//        if (p.getAge() != null) {
//            playerToUpdate.setAge(p.getAge());
//        }
//        if (p.getRating() != null) {
//            playerToUpdate.setRating(p.getRating());
//        }
//        if (p.getName() != null) {
//            playerToUpdate.setName(p.getName());
//        }
//        if (p.getYearsOfExperience() != null) {
//            playerToUpdate.setYearsOfExperience(p.getYearsOfExperience());
//        }
//        return playerRepository.save(playerToUpdate);
//    }
//
//    @DeleteMapping("/{id}")
//    public Player deletePlayer(@PathVariable("id") Integer id) {
//        Optional<Player> playerToDeleteOptional = playerRepository.findById(id);
//        if (playerToDeleteOptional.isEmpty()) {
//            return null;
//        }
//        Player playerToDelete = playerToDeleteOptional.get();
//        playerRepository.delete(playerToDelete);
//        return playerToDelete;
//    }
}
