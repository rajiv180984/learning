package com.Threading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerDemo {
    public static void main(String aa[]){
        List<String> queue = new ArrayList<>();
        Thread prod = new Thread(new ProducerThread(queue));
        Thread consumer = new Thread(new ConsumerThread(queue));
       consumer.start();
        prod.start();

    }
}


class ProducerThread implements Runnable{

    private List<String> queue = new LinkedList<>();

    public ProducerThread(final List<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
            for(int i=0;i<20;i++){
                System.out.println(" adding values");
                producer("test "+i);
            }
    }

    private void producer(String data){
        synchronized (this.queue){
            if(this.queue.size()==20){
                try {
                    System.out.println(" Queue is overflow ");
                    this.queue.wait();
                }
                catch (InterruptedException e) {
                }
                // else put into queue

            }
            queue.add(data);
            queue.notify();
        }
    }
}

class ConsumerThread implements Runnable{
    private List<String> queue = new LinkedList<>();

    public ConsumerThread(final List<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            consumer();
        }

    }

    public void consumer(){
        synchronized (this.queue){
            if(queue.isEmpty()){
                System.out.println(" No data in queue");
                try {
                   queue.wait();
                }
                catch (InterruptedException e) {
// TODO
                }
            }
            String data = queue.remove(queue.size()-1);
            System.out.println(" Consumer Data :"+data);
            queue.notify();
        }
    }
}