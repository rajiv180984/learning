package com.first.com.first.arrays;

public class BuyAndSellStock {
 public static void main(String aa[]){
     int pr[] = {100, 180, 260, 310, 40,535, 695};
 int x = singleTransactionProfit(pr);
     System.out.println(x);
 }

    public static int singleTransactionProfit(int pr[]){
     int mprofit =0;
     int min = pr[0];
     for (int i=1; i<pr.length; i++){
         mprofit = Math.max(pr[i]-min, mprofit);
         min= Math.min(pr[i], min);
     }

     return mprofit;
    }
}

