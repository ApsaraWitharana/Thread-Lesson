package org.example;


class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread   is Running!!");
    }
}
public class Main2  {
    public static void main(String[] args) {
        // create a interface
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
