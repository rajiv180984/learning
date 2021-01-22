package com.first.com.first.arrays;

public class Stack<T> {
    int top;
    Object arr[];
    Stack(){
        this.top = -1;
         this.arr = new Object[100];
    }
    public void push(Object data){
        if(top == 100){
            throw new RuntimeException();
        }
       synchronized (this) {
           top++;
           arr[top] = data;
       }
    }

    public Object pop(){
        if(top == -1){
            throw  new RuntimeException();
        }
        synchronized (this) {
            Object data = arr[top];
            arr[top] = null;
            top--;

            return data;
        }
    }


}
