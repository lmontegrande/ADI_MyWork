package com.example.lmont.sqlliteopenhelperdemo;

/**
 * Created by lmont on 8/23/2016.
 */
public class Game {
    long id;
    String name, year;

    public Game(long id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
