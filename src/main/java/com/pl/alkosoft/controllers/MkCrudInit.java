package com.pl.alkosoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/mkcrudinit")
public class MkCrudInit {

    private final PlayerService playerService;

    @Autowired
    public MkCrudInit(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void initData(@RequestBody PlayerJpa playerJpa){
        playerService.saveAllByJpa(playerJpa);
    }

}
