package com.oops.lolipop;

public class Demo {
    public static void main(String aa[]){
        TestStaticFunctionality test = null;
        test.testStaticFunc();

        LambdaFun s = ()->{
            System.out.println("Custome Implementation");
        };
        s.testFun();

    }

    // when double value is divide by double zero [0.0] than, it would not throw any ArithmaticException or Compile error.
    // It will return "Double.Infinity"
    public void doubleDevideByZero(){
        double val = 2.2;
        double val2 = 0.0;

        double res = val/val2;
        System.out.println("Result :"+res);
    }

    public static void testStaticFunc(){
        System.out.println(" Call Static method from null pointer");
    }
}

class TestStaticFunctionality{

    public static void testStaticFunc(){
        System.out.println(" Call Static method from null pointer");
    }
}

interface LambdaFun{
    public void testFun();
}
