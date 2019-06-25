package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public enum MediaType {

    BOOK  ("Book"),
    MOVIE ("Movie"),
    MUSIC ("Music"),
    VIDEOGAME ("Video game");

    private final String name;

    MediaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}