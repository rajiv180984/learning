package com.first.dp;

public class SubSetSumSolution {

    public static void main(String aa[]){
   int data[] ={1, 5,11,3,2,7};
   boolean res = isSubset(11, data, 6);
        System.out.println(res);

        boolean isPartitioin = isEqaulPartition(data,6);
        System.out.println(" Equal Partition :"+ isPartitioin);
    }

    public static boolean isSubset(int sum, int arr[], int n){
        // if sum ==0
        if(sum == 0){
            return true;
        }
        if(n== 0 && sum !=0){
            return false;
        }
        // if sum is less than last element or any element then return
        if(sum < arr[n-1]){
            return  isSubset(sum, arr, n-1);
        }

        // both node verify
        return isSubset(sum,arr, n-1) || isSubset(sum-arr[n-1], arr, n-1);
    }

    public static boolean isEqaulPartition(int arr[], int n){
        int total=0;
        for(int i=0;i<n; i++){
            total+=arr[i];
        }
        // for eqaul partition total should be eqaul
        if(total%2==0){
            // call subsetSum function
            return isSubset(total/2, arr, n);
        }else {
            return false;
        }
    }
}
