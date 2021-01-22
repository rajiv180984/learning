package com.first.matrix;

import java.util.Arrays;

public class MaxNumOfPath {
    public static void main(String a[]){
        int n = maxPahNum(4,4);
        System.out.println(" Maximum Path :"+ n);
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16,17}};
        int result[] = new int[arr.length + arr[0].length-1];
        print(arr, 0, 0, result,0);
        System.out.println("== :"+numberOfPaths(4,4));
    }

    static int numberOfPaths(int m, int n)
    {
        // Create a 2D table to store results
        // of subproblems
        int count[][] = new int[m][n];

        // Count of paths to reach any cell in
        // first column is 1
        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        // Count of paths to reach any cell in
        // first column is 1
        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        // Calculate count of paths for other
        // cells in bottom-up manner using
        // the recursive solution
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)

                // By uncommenting the last part the
                // code calculatest he total possible paths
                // if the diagonal Movements are allowed
                count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];

        }
        return count[m-1][n-1];
    }

    public static int maxPahNum(int row, int col){

        if(row ==1 || col ==1){
            return 1;
        }
       return maxPahNum(row-1,col)+maxPahNum(row, col-1);
    }

    public static void print(int arr[][],int row, int col,int result[],int pos){
        if(row == arr.length-1 && col == arr[0].length-1){
            result[pos] = arr[row][col];
            System.out.println(Arrays.toString(result));
            return;
        }
        if(row >= arr.length || col >= arr[0].length){
            return;
        }

        result[pos] = arr[row][col];
        print(arr,row,col+1,result,pos+1);
        print(arr,row+1,col,result,pos+1);
    }

}
