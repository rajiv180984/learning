package com.Threading;

public class Semaphore {
    boolean flag = true;

    public synchronized void take() {
        while (!flag) {
            try {
                System.out.println(" Semaphore not available");
                wait();
            }
            catch (InterruptedException e) {
// TODO
            }
        }
        flag = false;
        notify();
    }

    public synchronized void release() {

        while (flag) {
            try {
                System.out.println("It is free");
                wait();
            }
            catch (InterruptedException e) {
// TODO
            }
        }
        flag = true;
        notify();
    }
}


class SemaphoreCount {
    int signal;
    int bound;

    public SemaphoreCount(final int bound) {
        this.bound = bound;
        this.signal = 0;
    }

    public synchronized void take() {

        while (signal == bound) {
            try {
                System.out.println(" Wait for sometime Token is not available ");
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        signal++;
        notifyAll();
    }

    public synchronized void release() {
        while (signal == 0) {
            System.out.println(" There is nothing to release");
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        signal--;
        notifyAll();
    }
}