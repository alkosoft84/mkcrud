package com.pl.alkosoft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pl.alkosoft.model.PlayerMongo;
import com.pl.alkosoft.services.PlayerService;

/**
 * Created by mwrobel on 29.09.15.
 */
@RestController
public class PlayerListMongo {

    private final PlayerService playerService;

    @Autowired
    public PlayerListMongo(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/playerslistmongo", method = RequestMethod.GET)
    public List<PlayerMongo> getPlayersList() {
        return playerService.findAllMongo();
    }

    @RequestMapping(value = "/getplayermongo/{id}", method = RequestMethod.GET)
    public PlayerMongo getPlayer(@PathVariable("id") String id) {
        return playerService.getPlayerMongoById(id);
    }

    @RequestMapping(value = "/editplayermongo", method = RequestMethod.POST)
    public void addPlayer(@RequestBody PlayerMongo playerMongo) {
        playerService.saveMongo(playerMongo);
    }

    @RequestMapping(value = "/deleteplayermongo", method = RequestMethod.DELETE)
    public void deletePlayer(@RequestBody String playerId) {
        PlayerMongo playerMongo = playerService.getPlayerMongoById(playerId);
        playerService.deletePlayerMongo(playerMongo);
    }

}
