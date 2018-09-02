package com.Threading;

public class EvenOddApproach2 {
    public static void main(String aa[]) {
        TestObject value = new TestObject("Hello");
        Thread t1 = new Thread(new TestThread(value), "T1");
        t1.start();
        Thread t2 = new Thread(new OddThread(value), "T2");
        t2.start();

    }

}

class TestObject {
    private String s1;
    public int count;

    public TestObject(String s1) {
        this.s1 = s1;
        this.count = 0;

    }
}

class TestThread implements Runnable {

    private TestObject value;
    private int max = 20;

    public TestThread(final TestObject value) {
        this.value = value;
        this.max = 20;
    }

    @Override
    public void run() {
        synchronized (this.value) {
            System.out.println("This is thread :" + value);
            while (value.count < max) {
                if (value.count % 2 != 0) {
                    try {
                        value.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" : "+value.count);
                value.count++;
                value.notify();
            }
        }
    }
}



class OddThread implements Runnable {

    private TestObject value;
    private int max = 20;

    public OddThread(final TestObject value) {
        this.value = value;
    }

    @Override
    public void run() {
        synchronized (this.value) {
            System.out.println("This is thread :" + value);
            while (value.count < max) {
                if (value.count % 2 == 0) {
                    try {
                        value.wait();
                    }
                    catch (InterruptedException e) {
                        System.out.println("" + Thread.currentThread().getName());
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + value.count);
                value.count++;
                value.notify();
            }
        }
    }
}