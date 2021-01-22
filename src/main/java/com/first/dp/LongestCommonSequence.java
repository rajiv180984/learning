package com.first.dp;

import java.util.Map;

public class LongestCommonSequence {
    public static void main(String aa[]){
        System.out.println(commonSequence("AGGTAB","GXTXAYB"));
    }

    public static int commonSequence(String s1, String s2){

        int m = s1.length();
        int n = s2.length();
        if(m == 0 || n== 0 ){
            return 0;
        }

        int dp[][] = new int[m+1][n+1];

        for(int i=0; i<=s1.length();i++){
            for(int j =0; j<=s2.length();j++){
                if(i==0|| j==0){
                    dp[i][j]=0;
                }else
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[m][n];
    }
}
