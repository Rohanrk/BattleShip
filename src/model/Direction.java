package model;

/**
 * Created by rohanrk on 4/2/17.
 */
public enum Direction {

    NORTH("North"), SOUTH("South"), EAST("East"), WEST("West");

    private String name;


    Direction(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
