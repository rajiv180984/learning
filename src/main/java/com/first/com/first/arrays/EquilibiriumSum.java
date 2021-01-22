package com.first.com.first.arrays;

public class EquilibiriumSum {
    public static void main(String aa[]){
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int n = arr.length;

        System.out.println(equilibiriumIndex(arr,n));

        int data[] = {1,9,5,3,2,6,7,11};
        segragateEvenOdd(data, data.length);
        int arr1[]   = {10, 11, 12};
        int ind[] = {1, 0, 2};
        ReorderAnArray(arr1, ind);

        int arr2[]   = {0,0,1,7,3,2,3,0,0,6};

        moveAllZeroAtEnd(arr2, arr2.length);
        moveAllZeroLast(arr2, arr2.length);

    }

    public static int equilibiriumIndex(int arr[], int n){
        int I=-1;
        int sum=0;
        for(int x: arr){
            sum+=x;
        }
        int lsum=0;
        for(int i=0;i<n;i++){
            sum-=arr[i];
            if(sum == lsum){
                return i;
            }
            lsum+=arr[i];
        }
        return I;
    }

    public static void segragateEvenOdd(int data[], int n){

        int i=0;
        int j=n-1;
        while( i<j){
            if(data[i]%2==1 && data[j]%2==0){
                int temp =data[i];
                data[i]=data[j];
                data[j]= temp;
                i++;
                j--;
            }else{
                j--;
            }
        }

        for(int x: data){
            System.out.print("--"+x);
        }
    }

    public static boolean ReorderAnArray(int arr[], int ind[]){
        int n = arr.length;
        System.out.println("==================");
        for(int i=0; i<n;i++){
            // swap actual order and expected order define in index
            // swap(arr[i], arr[ind[i]])
            if(ind[i]>n-1){
                return false;
            }

        }

        for(int x: arr){
            System.out.print("--"+x);
        }
        return true;
    }

    public static void moveAllZeroAtEnd(int arr[], int n){
     //int arr2[]   = {0,0,1,7,3,2,3,0,0,6};

        int i =0;
     int j = n-1;
     while(i<j){
         if(arr[i]==0 && arr[j]!=0){
             arr[i] = arr[j];
             arr[j] = 0;
             i++;
             j--;
         }else if(arr[j]==0 || arr[i]==0  ){
             j--;
         } else {
             i++;
         }

     }
        System.out.println("==========  moveAllZeroAtEnd =====");
     for(int x : arr){
         System.out.print("--"+x);
     }
    }

    public static void moveAllZeroLast(int d[], int n){
        int count =0;
        for(int i=0; i<n-count; i++){
            if(d[i]==0){
                count++;
                d[i] = d[n-count-1];
            }
        }
        if(count>0 ) {
            for (int i = n - 1 - count; i < n; i++) {
                d[i] =0;
            }
        }

        System.out.println("==========  moveAllZeroAtEnd =====");
        for(int x : d){
            System.out.print("--"+x);
        }
    }


}
