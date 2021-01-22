package com.Threading;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue<T> {
    private List<T> list;

    public BlockingQueue() {
        this.list = new ArrayList<>();
    }

    public boolean putData(T data){

        synchronized (this.list){
            while(list.size()== Integer.MAX_VALUE){
                try {
                    list.wait();

                }
                catch (InterruptedException e) {
// TODO
                }
            }
        }
        list.add(data);
        notifyAll();
        return true;
    }

    public void readData(){
        synchronized (this.list){
            while (this.list.size()==0){
                try{list.wait();} catch (InterruptedException e){

                }
            }
            list.remove(this.list.size()-1);
            notifyAll();
        }
    }
}
