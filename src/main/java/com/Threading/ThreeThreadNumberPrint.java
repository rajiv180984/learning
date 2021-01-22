package com.Threading;

public class ThreeThreadNumberPrint {

    public static void main(String aa[]) {
        Monitor monitor = new Monitor(1, 1);
        Thread t1 = new Thread(new ThreadOne(monitor), "T1");
        Thread t2 = new Thread(new ThreadTwo(monitor), "T2");
        Thread t3 = new Thread(new ThreadThree(monitor), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}


class Monitor {
    int seq;
    int count;


    public Monitor(final int seq, final int count) {
        this.seq = seq;
        this.count = count;
    }
}

class ThreadOne implements Runnable {
    private Monitor monitor;

    public ThreadOne(final Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (this.monitor) {
            if (this.monitor.seq != 1) {
                try {
                    wait();
                }
                catch (InterruptedException e) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + monitor.count);
            monitor.count++;
            monitor.seq = 2;
            monitor.notifyAll();
        }
    }
}

class ThreadTwo implements Runnable {
    private Monitor monitor;

    public ThreadTwo(final Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {

        synchronized (this.monitor) {
            // while(this.monitor.seq != 2) {
            if (this.monitor.seq != 2) {
                try {
                    wait();
                }
                catch (InterruptedException e) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + monitor.count);
            monitor.count++;
            monitor.seq = 3;
            monitor.notifyAll();
        }

    }
}

class ThreadThree implements Runnable {
    private Monitor monitor;

    public ThreadThree(final Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (this.monitor) {
            if (this.monitor.seq != 3) {
                try {
                    wait();
                }
                catch (InterruptedException e) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + monitor.count);
            monitor.count++;
            monitor.seq = 1;
            monitor.notifyAll();
        }
    }
}
