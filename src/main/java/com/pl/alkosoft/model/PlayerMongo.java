package com.pl.alkosoft.model;


import org.springframework.data.annotation.Id;

/**
 * Created by mwrobel on 29.09.15.
 */
public class PlayerMongo {

    @Id
    private String id;

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
