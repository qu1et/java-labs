package com.univer.lab1;

class SquareEvenNumber implements Runnable {
    double x;

    SquareEvenNumber(double x) {
        this.x = x;
    }

    public void run() {
        System.out.format("Square of the %.1f - %.1f\n", x, x*x);
    }
}

class CubeOddNumber implements Runnable {
    double x;Ф

    CubeOddNumber(double x) {
        this.x = x;
    }

    public void run() {
        System.out.format("Cube of the %.1f - %.1f\n", x, x*x*x);
    }
}

public class Lab1 {
    public static void main(String[] args) throws InterruptedException {
        double x;

        while(true) {
            Thread.sleep(1000);

            x = Math.floor(Math.random() * 20);
            System.out.format("Random number: %.1f\n", x);

            if (x % 2 == 0) {
                Thread t = new Thread(new SquareEvenNumber(x));
                t.start();
            } else {
                Thread t = new Thread(new CubeOddNumber(x));
                t.start();
            }
        }
    }
}
