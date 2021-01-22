package com.Threading;

public class EvenOddNumberThread {

    public static void main(String aa[]) {
        Integer value = new Integer(1);
        Counter count = new Counter(20);
        Thread t1 = new Thread(new MyThread(count));
        Thread t2 = new Thread(new Even(count));
        t1.start();
        t2.start();
    }

}

class MyThread implements Runnable {

    private Counter counter;

    public MyThread(final Counter counter) {
            this.counter = counter;

    }

    @Override
    public void run() {
        while (true) {
            this.counter.printNextOdd();
        }
    }
}

class Even implements Runnable {

    private Counter counter;

    public Even(final Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            this.counter.printNextEven();
        }
    }
}


class Counter {

    private int count = 0;
    private boolean even = true;
    private int upperLimit;

    Counter(int limit) {
        upperLimit = limit;
    }

    public synchronized int printNextOdd() {
        //Wait until odd is available.
        while (even) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        count++;
        if (count <= upperLimit) {
            printEven(count);
        }
        //Toggle status.
        even = true;
        //Notify even printer that status has changed.
        notifyAll();
        return count;

    }

    public synchronized int printNextEven() {
        //Wait until even is available.
        while (!even) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        count++;
        if (count <= upperLimit) {
            printOdd(count);
        }
        //Toggle status.
        even = false;
        //Notify odd printer that status has changed.
        notifyAll();
        return count;
    }

    public void printOdd(int num) {
        System.out.println("ODD # " + num);
    }

    public void printEven(int num) {
        System.out.println("EVEN # " + num);
    }
}