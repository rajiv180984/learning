package com.first.dp;

public class MaxGoldCollectionDP {

    public int maxGoldCalculate(int gold[]){
        int max=0;
        int n = gold.length;
        int dp[] = new int[n];

        dp[0] =gold[0];
        dp[1] = gold[1];
        for (int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+gold[i], dp[i-1]);

        }
        return dp[n-1];
    }

}
