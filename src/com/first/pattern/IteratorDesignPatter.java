package com.first.pattern;

import java.util.ArrayList;
import java.util.List;


public class IteratorDesignPatter {
 public static  void main(String aa[]){
     TestCollection tc = new CustomCollection();
     tc.add(new String("Testing"));
     tc.add(new String("Testing2"));
     Iterator it = tc.createIterator();

     System.out.println(it.hasNext()+""+it.next());
    // it.hasNext();
     //it.hasNext();
     System.out.println(it.hasNext()+""+it.next());

 }
}


interface Iterator{
    boolean hasNext();
    Object next();
}

class JumpIterator implements  Iterator{

    private List<Object> list;
    private int postion;
    private  int size;
    public JumpIterator(final List<Object> list) {
        this.list = list;
        this.postion=0;
        this.size = list.size();
    }

    @Override
    public boolean hasNext() {
        if(this.size%2!=0){
            System.out.println(" CHal bhag Bhosdi wale");

        }
        if(this.postion<this.size){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return  list.get(postion++);
    }
}

interface  TestCollection{
    boolean add(Object data);
    Iterator createIterator();

}

class CustomCollection implements TestCollection{

    private List<Object> list;

    public CustomCollection() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(final Object data) {
        list.add(data);
        return true;
    }

    @Override
    public Iterator createIterator() {
         return new JumpIterator(this.list);
    }
}