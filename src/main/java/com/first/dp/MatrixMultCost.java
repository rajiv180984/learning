package com.first.dp;

public class MatrixMultCost {

    public static void main(String aa[]){



    }

    public static int MatrixMultCostFun(int p[]){
        int n= p.length;
        int mat[][] = new int[n][n];

        for(int i=0;i<n;i++){
            mat[i][i]=0;
        }
        //lenth `of mtrix mutliplication group from 2 to n;
        // j: j is end point of multipliction
        int j=0;
        for(int l=2; l<n;l++){
            // for starting to make different group
            for(int i=0;i<n;i++){
                // if length is l, and start from i the it should end at j
                j= i+l-1;
                mat[i][j] = Integer.MAX_VALUE;
                // try with different partition A1,A2, A3==A1(A2A3) OR (A1, A2)A3
                for(int k=i;k<j;k++){
                    int q = mat[i][k]+mat[k+1][j]+p[i-1]*p[k]*p[j];
                    if(q<mat[i][j]){
                        mat[i][j]=q;
                    }
                }
            }
        }

        return mat[1][n-1];
    }
}
