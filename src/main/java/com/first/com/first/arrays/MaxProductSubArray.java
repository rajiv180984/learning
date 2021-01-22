package com.first.com.first.arrays;

public class MaxProductSubArray {
    public static void main(String aa[]) {
        System.out.println("====== Max Product Sub Array ==========");
        MaxProductSubArraySolution();

    }

    public static void MaxProductSubArraySolution() {
        int a[] = {6, -3, -10, 0, 2};
        int min_end = 1; // if nigative max multiply with next negative number that become positive max
        int max_end = 1; // all number positive or even no of negative
        int so_far_max = 1;
        int n = a.length;

        for (int i = 0; i < n; i++) {

            if (a[i] > 0) {
                max_end = max_end * a[i];
                min_end = Math.max(min_end * a[i], 1);
            }
            if (a[i] == 0) {
                max_end = 1;
                min_end = 1;
            }
            if (a[i] < 0) {
                int temp = min_end; // for next (-) ve multiplier
                max_end = Math.min(min_end * a[i], 1);
                min_end = temp * a[i];
            }
            System.out.println(" ====" + max_end + " :" + min_end);
            max_end = Math.max(max_end, min_end);
            if (so_far_max < max_end) {
                so_far_max = max_end;
            }

        }
        System.out.println(" Max product :" + so_far_max);
        //return so_far_max;
    }

}
