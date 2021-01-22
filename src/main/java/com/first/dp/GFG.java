package com.first.dp;

import java.util.Arrays;

class GFG {
     
    // Returns true if there is a subset
    // of set[] with sum equal to given sum
    static boolean isSubsetSum(int set[],
                            int n, int sum)
    {
        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
         
        // If last element is greater than 
        // sum, then ignore it
        if (set[n - 1] > sum) {
            return isSubsetSum(set, n - 1, sum);
        }
         
        /* else, check if sum can be obtained 
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSum(set, n-1, sum) || 
            isSubsetSum(set, n-1, sum-set[n-1]);
    }
     
    /* Driver program to test above function */
    public static void main (String args[])
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 13;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true) {
            System.out.println("Found a subset"
                    + " with given sum");
        }
        else {
            System.out.println("No subset with"
                    + " given sum");
        }

       int x = noOfWays(6, 3, 11);
        System.out.println(" Number of Ways :"+x);
    }

    public static int noOfWays(int m, int dices, int sumX)
    {
        int table[][] = new int[dices + 1][sumX + 1];

        // Fill the tables if only one dice is present
        for (int j = 1; j <= m && j <= sumX; j++)
            table[1][j] = 1;

        // Fill rest of the table using the equation we formed
        for (int i = 2; i <= dices; i++)     // No of dices
            for (int j = 1; j <= sumX; j++)
                for (int k = 1; k <= m && k < j; k++)
                    table[i][j] += table[i-1][j-k];

    // Uncomment these lines to see content of table
     for (int[] arr : table) {
            System.out.println(Arrays.toString(arr));
        }

        return table[dices][sumX];
    }
}