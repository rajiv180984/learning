package com.first.inheritance;

import java.io.IOException;
import java.sql.SQLException;

public class TestA {
    protected void fun() throws Exception {
        System.out.println(" TestA");
    }

    protected  void funExceTest(){
        System.out.println(" TestA : funExceTest");
    }
    public static void main(String aa[]){
        TestA t = new TestB();

    }
}

class TestB extends TestA{
    @Override
    protected void fun()  throws IOException{
        System.out.println("Test B");
    }

    public  void funExceTest() throws RuntimeException {
        System.out.println(" TestA : ");
    }
}
