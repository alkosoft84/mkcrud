package com.pl.alkosoft.model;

import javax.persistence.Embeddable;

/**
 * Created by mwrobel on 29.09.15.
 */
@Embeddable
public class Player {

    private String name;

    private String character;

    private Integer reputation;

    private String imageLink;

    private String story;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(final String character) {
        this.character = character;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(final Integer reputation) {
        this.reputation = reputation;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(final String imageLink) {
        this.imageLink = imageLink;
    }

    public String getStory() {
        return story;
    }

    public void setStory(final String story) {
        this.story = story;
    }
}
