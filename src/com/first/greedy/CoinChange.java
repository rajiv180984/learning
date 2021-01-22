package com.first.greedy;

public class CoinChange {

    public static void main(String aa[]){
        int coin[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int coint  = minCoin(coin, 69);
        System.out.println(coint);
    }
    public static int minCoin(int coin[], int V){
        int count =0;

        int n= coin.length;
        int noteValue=0;
        int numCoin = 0;
         for (int i=n-1; i>=0;i--){
             noteValue = coin[i];
             if( (float)V/coin[i] >=1 ){
                 numCoin = V/coin[i];
                 V = V%coin[i];
                 count+=numCoin;
             }
             continue;
         }
        return count;
    }
}
