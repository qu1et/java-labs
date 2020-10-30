package com.labs;

import java.util.Random;

public class Enemy extends Player {
    Random rand = new Random();

    Enemy(String name) {
        super(name);
    }

    public int makeGuess() {
        return rand.nextInt(20) + 1;
    }

    void displayHit() {
        System.out.println("Вы угадали, теперь у врага с именем " +
                this.name + " осталось " + this.health + "HP!");
    }

    void displayMiss(int num) {
        if (this.number > num) {
            System.out.println("Вы не угадали! Число, что вы пытаетесь " +
                    "угадать больше");
        } else {
            System.out.println("Вы не угадали! Число, что вы пытаетесь " +
                    "угадать меньше");
        }
    }
}
