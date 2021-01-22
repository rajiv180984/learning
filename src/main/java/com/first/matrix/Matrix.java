package com.first.matrix;

public class Matrix {

    public  static void main(String aa[]){
        int mat[][] = {{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20},
        };
        Matrix matrix = new Matrix();
        matrix.diagonalPrint(4,4, mat);
    }
    public void rowandColSortedAmtrix(int x){
        int a[][]= { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int n = a.length;
        int row=0;
        for(int i =0; i<n;i++){
            if(a[i][0]<x){
                row = i;
                continue;
            }
        }
        // apply binary seach on same row or do linear search

    }

    public void diagonalPrint(int m, int n, int [][]mat){
           for(int row=0; row<m; row++){
               matPrint(row, 0, mat);
               System.out.println();
           }
           for(int col = 1 ; col<n; col++ ){
               matPrint(m, col, mat);
               System.out.println();
           }
    }




    public void matPrint(int m,int n, int [][]mat){

        int row = m;
        int col =n;
        System.out.println(row+"  and "+col);

        for(int i=0; i<=m ;i++){
            System.out.print("--"+mat[row-i][col+i]);
        }

    }
}
