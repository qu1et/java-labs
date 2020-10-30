package com.labs;

public class User extends Player {
    User(String name) {
        super(name);
    }

    void displayHit() {
        System.out.println("Враг попал в вас! У " +
                this.name + " осталось " + this.health + "HP!");
    }

    void displayMiss() {
        System.out.println("Враг не угадал число");
    }
}
