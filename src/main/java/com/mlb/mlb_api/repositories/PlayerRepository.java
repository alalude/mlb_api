package com.mlb.mlb_api.repositories;

import com.mlb.mlb_api.repositories.entities.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    // Methods created by JPA live here
    List<Player> findByName(String name);
}
