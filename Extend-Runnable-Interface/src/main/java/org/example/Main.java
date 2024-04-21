package org.example;

class One implements Runnable{

    @Override
    public void run() {
        for (int i=1; i<=5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread One");
        }
    }
}

class Two implements Runnable{

    @Override
    public void run() {
        for (int i=1; i<=5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread Two");
        }

    }
}
public class Main {
    public static void main(String[] args) {
        Runnable one = new One();
        Runnable two = new Two();
        Thread t1 = new Thread(one);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread t2 = new Thread(two);
        t2.start();

        System.out.println("Hello world!");
    }
}