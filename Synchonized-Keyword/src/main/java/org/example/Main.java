package org.example;

class Calculate{
    int num;

    public synchronized void increment(){
        num++;
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calculate calculate = new Calculate();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <=1000; i++) {
                calculate.increment();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                calculate.increment();


                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Calculate:"+calculate.num);
    }
}