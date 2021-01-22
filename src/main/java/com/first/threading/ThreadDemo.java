package com.first.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {

    public static  void main(String aa[]){
        Thread t = new Thread(new printThread(10));
        Thread t1 = new Thread(new printThread(20));
       // t.start();
        //t1.start();

        ExecutorService exec = Executors.newFixedThreadPool(4);
        exec.submit(t);
        exec.submit(t1);
        Future<Object> future = exec.submit(new copyThread());

        System.out.println("==========: "+future.isDone());
    }
}


class printThread implements Runnable{
    private int no;
    public printThread(int no) {
    this.no= no;
    }

    @Override
    public void run() {
        System.out.println("this is print thread"+ no);
    }
}

class copyThread implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println(" This is copy thread ");
        return new Object();
    }
}