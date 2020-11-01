package com.labs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Thread> threadList = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java lab3 <URL> <depth> <threads>");
            System.exit(1);
        }

        int maxDepth = 0;
        int numberOfThreads = 0;
        int maxPatience = 0;

        try {
            maxDepth = Integer.parseInt(args[1]);
            numberOfThreads = Integer.parseInt(args[2]);
            maxPatience = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.out.println("The second and third arguments must be integer");
            System.exit(1);
        }

        URLPool urlPool = new URLPool(maxDepth);
        try {
            urlPool.put(new UrlDepthPair(new URL(args[0]), 0));
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

        for (int i = 0; i < numberOfThreads; i++) {
            WebCrawler crawler = new WebCrawler(urlPool, maxPatience);
            Thread thread = new Thread(crawler);
            threadList.add(thread);
            thread.start();
        }

        while (urlPool.getWaitingThreads() != numberOfThreads) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception");
            }
        }

        urlPool.seen().stream().forEach(System.out::println);

        threadList.stream().forEach(Thread::interrupt);
    }
}
