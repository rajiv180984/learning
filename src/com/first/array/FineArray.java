package com.first.array;

public class FineArray {
    public static void main(String aa[]) {
        int arr[] = {2, 2, 0, 4, 0, 8};
        int n = arr.length;
        // if two consecutive number same then sum up at first position and next number should be 0
        int zero =0;
        for(int i=0 ; i<n && i-zero+1<n; i++){
            if(arr[i]==0){
                zero++;
            }else {
                arr[i-zero] = arr[i];
                int count =0;
                for (int j = 1; j+i < n; j++) {
                    if (arr[i] == arr[i+j]) {
                        count++;
                        arr[i+j] = 0;
                    }
                    else {
                        break;
                    }
                }
                arr[i]= arr[i]*(count+1);
            }

        }

        for(int i=n-zero;i<n;i++ ){
            arr[i] = 0;
        }
        for (int i:arr){
            System.out.print("--"+i);
        }
    }

    public static void segragateZero( int arr[]){
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n;i++){
            if(arr[i]==0){
                count++;
            }/*else {
                arr[i]
            }*/

        }

    }
}
