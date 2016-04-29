package com.pl.alkosoft.model;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mwrobel on 29.09.15.
 */
@Entity
public class PlayerJpa {

    @Id
    @GeneratedValue
    private String id;


    @Embedded
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(final Player player) {
        this.player = player;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}
