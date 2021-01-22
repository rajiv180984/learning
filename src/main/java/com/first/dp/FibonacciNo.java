package com.first.dp;

public class FibonacciNo {

    public int uglyNum(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return uglyNum(n-1)+uglyNum(n-2);
    }

    public int fabonacciByDP(int n){
        int f[] = new int[n+2];
        f[0] = 0;
        f[1] = 1;
        for(int i=2; i<=n;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return  f[n];
    }
}
