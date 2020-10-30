package com.labs;

import java.util.Random;

public class Player {
    protected int number;
    protected String name;
    protected int health;
    Random rand = new Random();

    Player(String name) {
        this.name = name;
        this.health = 100;
        this.number = rand.nextInt(20) + 1;
    }

    public boolean checkTheHit(int num) {
        return this.number == num;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    void generateNewNumber() {
        this.number = rand.nextInt(20) + 1;
    }

    void decreaseHealth() {
        this.health -= 10;
    }
}
