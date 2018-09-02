package com.first.java.immutable;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

class InnerClassDemo {
    static int data = 30;

    static class Inner {
        void msg() {
            System.out.println("data is " + data);
        }
    }

    public static void main(String args[]) {
        InnerClassDemo.Inner obj = new InnerClassDemo.Inner();
        Map<String, String> map = new ConcurrentHashMap<>();
        Map<String, String> nmap =  new ConcurrentSkipListMap<String, String>() ;

        InnerClassDemo demo = null;
        demo.testFunc();

        obj.msg();
        Person p = new Person() {
            void eat() {
                System.out.println("nice fruits");
            }
        };
        p.eat();
        InnerClassDemo id = new InnerClassDemo();
        id.innerTestFunc();
    }

    public void innerTestFunc(){
        System.out.println("This is initial ");
        class Inner{
            public void print(){
                System.out.println("======== Printing ===========");
            }
        }

        Inner inner = new Inner();
        inner.print();
    }

    public static void testFunc(){
        System.out.println(" This is static method");
    }
}

abstract class Person {

    abstract void eat();

}