package com.first.array;

import java.util.Arrays;

public class ChocolatesDistribution {

    public static void main(String aa[]){
        CocolateDistributionDemo();
    }

    private static void CocolateDistributionDemo() {
        int arr[] = {1,4,7,12,13,15,27,26,100};
        int m= 3;
        int j=0;
        int diff= Integer.MAX_VALUE;
        int Idiff = -1;
        Arrays.sort(arr);
        for(int i=0;(i+m-1)<arr.length;i++){
           if((arr[i+m-1]-arr[i])<diff){
               diff =(arr[i+m-1]-arr[i]);
               Idiff = i;
           }
        }
        System.out.println(" Packer from Idex :"+Idiff +" : "+ (Idiff+m));
    }

}
