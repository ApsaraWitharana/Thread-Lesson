package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread One ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread Two ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        //eka thread ekk exsicution ek iwara unam tamyi next thread ek run wenn gnnne
        //isAlive method eken puluwan me thread ek tam run wenwad kiyl blnn
        t1.join();
        t2.join();
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        //main method eken ena sout ek
        System.out.println("End");

    }
}