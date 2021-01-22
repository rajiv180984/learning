package com.first.dp;

public class MaxiMumStoleSolution {

    public static void maxStolen(int gold[]){
        int dp[] = new int[gold.length];
        // intialize memoiazation
         dp[0] =  gold[0];
         dp[1] = gold[1];
        for(int i=2; i<gold.length; i++){
            dp[i] = Math.max(gold[i]+dp[i-2], dp[i-1]);
        }

        System.out.println("========= "+ dp[gold.length-1]);
    }

    public static void main(String aa[]){
        int gold[] = {6, 7, 1, 3, 8, 2, 4};
        maxStolen(gold);
    }
}
