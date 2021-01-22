package com.Threading;

public class DeadLock {

    public static void main(String aa[]) {
        String s1 = "String one";
        String s2 = "String two";
        Thread t1 = new Thread(new CustomThread(s1, s2));
        Thread t2 = new Thread(new CustomThread(s2, s1));
        t1.start();
        t2.start();

    }
}

class CustomThread implements Runnable {

    private String s1;
    private String s2;

    public CustomThread(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        test();
       // test2();
    }

    private void test() {
        synchronized (this.s1) {
            System.out.println(" Print :" + s1);
            synchronized (this.s2){
                System.out.println(" Print :" + s2);
            }
        }
    }


    private void test2() {
        synchronized (this.s1) {
            System.out.println(" Print :" + s2);
        }
    }
}
