package com.fico.second;

import java.util.Map;

public class BuyAndSellSolution {
    public static void main(String aa[]){

        int data[] = {10, 20, 5, 15, 18, 70, 18};
        buyAndSell(data);
        singleBuy(data);
    }

    public static void buyAndSell(int data[]){
        int min =0;
        int mprofit = 0;
        stock buy = new stock();
        stock sell = new stock();
        for (int i=0;i<data.length;i++){
            mprofit = Math.max(data[i]-min, mprofit);
            min = Math.min(data[i], min);

        }
        System.out.println(mprofit);
    }

    public static int singleBuy(int a[]){
        int mP = -1;
        int min =a[0];
        int profit = 0;
        for(int i=1; i<a.length;i++){
            profit = a[i] -min;
            mP = Math.max(profit,mP);
            min = Math.min(min, a[i]);

        }
        System.out.println(" Single BUy Profit :"+mP);
        return mP;

    }
}

class stock{
    int price;
    int day;

    public stock(){

    }
    public stock(final int price, final int day) {
        this.price = price;
        this.day = day;
    }
}