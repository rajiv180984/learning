package com.first.dp;

public class LongestIncreasingSequence {
    public static void main(String aa[]){
        int a[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        maxIncreaseSeq(a);
    }
    
    public static void maxIncreaseSeq(int a[]){
        int n = a.length;
        int aux[] = new int[n];
        for (int i=0; i<n;i++) {
            aux[i]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    aux[i] = Math.max(aux[j]+1, aux[i]);
                }
            }
        }

        System.out.println(" Longest Sequence :"+ aux[n-1]);
        for(int i: aux){
            System.out.print("---"+i);
        }
    }
}
