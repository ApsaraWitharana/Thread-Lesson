package org.example;
class Q{
    int num;
    boolean value = false;
    public synchronized void put(int num) throws InterruptedException {
//        for ()
        while (value){
            wait();
        }

        System.out.println("Put :"+ num);
        this.num =num;
        value =true;
        notify();

    }

    public synchronized void get() throws InterruptedException {
        while (!value){
            wait();
        }
        System.out.println("Get :"+ num);
        value=false;
        notify();

    }
}

class Producer implements Runnable{

    Q q;
    public Producer(Q q){
        this.q =q;

        Thread thread = new Thread(this,"Producer");
        thread.start();
    }
    @Override
    public void run() {
        int i =0;
        while (true){
            try {
                q.put(i++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable{

    Q q;
    public Consumer(Q q){
        this.q =q;

        Thread thread = new Thread(this,"Consumer");
        thread.start();
    }
    @Override
    public void run() {

        while (true){
            try {
                q.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);


    }
}