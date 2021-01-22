package com.first.dp;

public class FriendPairing {
    public static void main(String aa[]) {
        FriendPairing fp = new FriendPairing();
        System.out.println("=========" + fp.allPossiblePair(3));

    }

    // case 1: all paired except 1
    // one is single that can be cobinined remaining n-2 paired candidate
    public int allPossiblePair(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
       // dp[2] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }
}
