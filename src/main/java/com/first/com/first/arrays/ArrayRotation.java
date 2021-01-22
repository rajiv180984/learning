package com.first.com.first.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArrayRotation {
    public static void main(String aa[]){

        int data[] = {1,2,3,4,5,6,7};
        Arrays.sort(data);
        int n = data.length;
        data = rotateArray(data, 2);
   for(int i=0;i<n;i++){
       System.out.print("--"+data[i]);
   }
    }

    public static int[] rotateArray(int data[], int k){

        int n = data.length;
        for(int j=0;j<k;j++){
            int temp = data[0];
            for(int i=0;i<n-1;i++){
                data[i]=data[i+1];
            }
            data[n-1] = temp;
        }
        return data;
    }

    public static int[] jumping(int data[], int k){

        int n = data.length;
            for(int i=0;i<n-k;i++){
                data[i]=data[i+k];
            }
        return data;
    }

}
