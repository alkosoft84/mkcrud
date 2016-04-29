package com.pl.alkosoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pl.alkosoft.model.Player;
import com.pl.alkosoft.model.PlayerJpa;
import com.pl.alkosoft.model.PlayerMongo;
import com.pl.alkosoft.repositories.PlayerRepositoryJpa;
import com.pl.alkosoft.repositories.PlayerRepositoryMongo;

/**
 * Created by mwrobel on 30.10.15.
 */
@Service
public class PlayerService {

    private final PlayerRepositoryJpa playerRepositoryJpa;

    private final PlayerRepositoryMongo playerRepositoryMongo;

    @Autowired
    public PlayerService(final PlayerRepositoryJpa playerRepositoryJpa, PlayerRepositoryMongo playerRepositoryMongo) {
        this.playerRepositoryJpa = playerRepositoryJpa;
        this.playerRepositoryMongo = playerRepositoryMongo;
    }

    public List<PlayerJpa> findAllJpa() {
        return playerRepositoryJpa.findAll();
    }

    public List<PlayerMongo> findAllMongo() {
        return playerRepositoryMongo.findAll();
    }

    public void saveAllByJpa(final PlayerJpa playerJpa) {
        playerRepositoryJpa.save(playerJpa);
        PlayerMongo playerMongo = copyPlayerFromJpaToMongo(playerJpa);
        playerRepositoryMongo.save(playerMongo);
    }

    public void saveJpa(final PlayerJpa playerJpa) {
        playerRepositoryJpa.save(playerJpa);
    }

    public void saveMongo(final PlayerMongo playerMongo) {
        playerRepositoryMongo.save(playerMongo);
    }

    public void deletePlayerJpa(final PlayerJpa playerJpa) {
        playerRepositoryJpa.delete(playerJpa);
    }

    public void deletePlayerMongo(final PlayerMongo playerMongo) {
        playerRepositoryMongo.delete(playerMongo);
    }

    public PlayerJpa getPlayerJpaById(String id) {
        return playerRepositoryJpa.findOne(id);
    }

    public PlayerMongo getPlayerMongoById(String id) {
        return playerRepositoryMongo.findOne(id);
    }

    private PlayerMongo copyPlayerFromJpaToMongo(final PlayerJpa playerJpa) {
        PlayerMongo playerMongo = new PlayerMongo();
        Player player = new Player();
        player.setName(playerJpa.getPlayer().getName());
        player.setCharacter(playerJpa.getPlayer().getCharacter());
        player.setReputation(playerJpa.getPlayer().getReputation());
        player.setImageLink(playerJpa.getPlayer().getImageLink());
        player.setStory(playerJpa.getPlayer().getStory());
        playerMongo.setPlayer(player);
        return playerMongo;
    }
}
