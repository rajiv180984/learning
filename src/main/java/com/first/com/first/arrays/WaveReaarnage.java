package com.first.com.first.arrays;

import java.util.Arrays;

public class WaveReaarnage {
    public static void main(String aa[]) {
        int data[] = {1, 9, 5, 3, 2, 6, 7, 11};
        int data1[] = {5, 2, 8, 3, 25, 15, 6, 8, 11};

        System.out.println("========================");
        waveReaarnage(data1);

    }


    public static void waveReaarnage(int data[]) {

        Arrays.sort(data);
        for (int i = 0; i < data.length - 1; i = i + 2) {
            int t = data[i + 1];
            data[i + 1] = data[i];
            data[i] = t;
        }
        for (int x : data) {
            System.out.print("--" + x);
        }
    }
}
