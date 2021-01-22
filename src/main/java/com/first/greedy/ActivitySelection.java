package com.first.greedy;

public class ActivitySelection {
    public static void main(String aa[]) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};
        activitySelectionSol(start, finish);
    }

    // activity should be sorted with their finish time.
    public static void activitySelectionSol(int start[], int finish[]) {

        int n = start.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            // finish time of one activity should be at least equal of greater than another activity
            if (start[j] >= finish[i]) {
                System.out.println(" Selected Activity index :" + i);
                i = j;
            }
        }
    }
}
