package com.first.com.first.arrays;

public class PowerFun {
    public static void main(String aa[]){
        System.out.println(" Power Funt "+power(2,4));
    }

    public static int power(int m, int n){
        if(n==0){
            return 1;
        }else{
            return m*power(m, n-1);
        }
    }
}
