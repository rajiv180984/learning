package com.first.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionDemo {

    public static void main(String aa[]){

        ConcurrentHashMap<String, String> conMap = new ConcurrentHashMap<>(10);


        NavigableSet<String> set = new TreeSet<>();
        NavigableSet<String> sortedSet = new TreeSet<>();
        set.add("zebra");
        set.add("aebra");
        set.add("gebra");
        System.out.println(set.toString());
        Set<String> subSet = set.headSet("gebra");

        sortedSet.descendingSet();
        System.out.println(" subset :"+ set.descendingSet());
        System.out.println("Ceiling "+set.ceiling("a"));



        Iterator it = set.descendingIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
