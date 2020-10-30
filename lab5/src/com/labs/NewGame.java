package com.labs;

import java.util.*;

public class NewGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String userName = scanner.nextLine();
        System.out.println("Введите имя вашего оппонента:");
        String enemyName = scanner.nextLine();
        int num = 0;

        User user = new User(userName);
        Enemy enemy = new Enemy(enemyName);

        while (true) {
            System.out.println("Введите число от 1 до 20");
            num = scanner.nextInt();

            if (enemy.checkTheHit(num)) {
                enemy.decreaseHealth();
                if (enemy.isDead()) {
                    System.out.println("Поздравляем! Вы победили!");
                    break;
                } else {
                    enemy.displayHit();
                    enemy.generateNewNumber();
                }
            } else {
                enemy.displayMiss(num);
            }

            num = enemy.makeGuess();
            if (user.checkTheHit(num)) {
                user.displayHit();
                user.decreaseHealth();
                if (user.isDead()) {
                    System.out.println("Поздравляем! Вы проиграли компьютеру и доказали несовершенность человечества!");
                    break;
                } else {
                    user.generateNewNumber();
                }
            } else {
                user.displayMiss();
            }
        }
    }
}

