package com.first.array;

public class SearchInRotateArray {
    public static void main(String aa[]) {
        int a[] = {4, 5, 6, 7, 8, 9, 3, 2, 1};
    }

    // poivetd point means left contain higher element and right contain less element or point from where array was rotate
    public static int pivotedPoint(int a[], int l, int h) {
        //
        int m = (l + h) / 2;
        while (l <= h) {
            if (a[m] < a[m - 1] && a[m] > a[m + 1]) {
                return m;
            }
            
        }
        return m;
    }
}
