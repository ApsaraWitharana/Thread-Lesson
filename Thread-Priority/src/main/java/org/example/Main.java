package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i=1; i<=5; i++){
                System.out.println("Thread one");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i=1; i<=5; i++){
                System.out.println("Thread two");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //scaduler tamyi gnne mokkd kiyl bllne - sages ktana ekk witarayi wenne
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        // thread kiyipayk tiyenkot wen kral hadunagnn namak set kranne
        t1.setName("Calculation Thread");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t1.getName());
        t1.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        t1.join();
        t2.join();

        System.out.println("bye");
    }
}