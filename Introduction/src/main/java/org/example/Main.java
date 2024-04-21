package org.example;


class MyThread extends Thread{

    public void run(){
        System.out.println("MyFriend Thread!!");
    }

}
public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //run the thread class using start method
        myThread.start();
        System.out.println("Hello world!");
    }
}