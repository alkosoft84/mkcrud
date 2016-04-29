package com.pl.alkosoft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pl.alkosoft.model.PlayerJpa;
import com.pl.alkosoft.services.PlayerService;

/**
 * Created by mwrobel on 29.09.15.
 */
@RestController
public class PlayerListJpa {

    private final PlayerService playerService;

    @Autowired
    public PlayerListJpa(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/playerslistjpa", method = RequestMethod.GET)
    public List<PlayerJpa> getPlayersList() {
        return playerService.findAllJpa();
    }

    @RequestMapping(value = "/getplayerjpa/{id}", method = RequestMethod.GET)
    public PlayerJpa getPlayer(@PathVariable("id") String id) {
        if (id != null) {
            return playerService.getPlayerJpaById(id);
        }
        return new PlayerJpa();
    }

    @RequestMapping(value = "/editplayerjpa", method = RequestMethod.POST)
    public void savePlayer(@RequestBody PlayerJpa playerJpa) {
        playerService.saveJpa(playerJpa);
    }

    @RequestMapping(value = "/deleteplayerjpa", method = RequestMethod.DELETE)
    public void deletePlayer(@RequestBody String playerId) {
        PlayerJpa playerJpa = playerService.getPlayerJpaById(playerId);
        playerService.deletePlayerJpa(playerJpa);
    }

}
