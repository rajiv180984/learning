package com.first.java.immutable;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableWithList {
    private final String test;
    private final ArrayList<String> list;

    public ImmutableWithList(final String test, final  ArrayList<String> list) {
        this.test = test;
        ArrayList<String> list1 = new ArrayList<>();
        
        this.list = list;
    }

    public String getTest() {
        return test;
    }

    public ArrayList<String> getList() {
        return (ArrayList<String>) list.clone();
       // return list;
    }

    public static void main(String aa[]){
        System.out.println("Immutable Test");
        ArrayList<String> list = new ArrayList();
        list.add("hello");
        ImmutableWithList iw = new ImmutableWithList("Testing",list);

        System.out.println("===== 1st :"+ iw.hashCode()+" and ==== "+iw.getList().hashCode()+" and "+list.hashCode());

        iw.getList().add("Test2");

        System.out.println("===== 1st :"+ iw.hashCode()+" ==== "+iw.getList().hashCode());

    }

}
