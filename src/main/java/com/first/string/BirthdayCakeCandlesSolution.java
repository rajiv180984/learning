package com.first.string;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class BirthdayCakeCandlesSolution {

    /*
     * Complete the birthdayCakeCandles function below.
     */
    static int birthdayCakeCandles(int n, int[] ar) {
       int m=-100;
        int cn =0;
        for(int x:ar){
            if(x==m){
                cn++;
            }
            if(x>m){
             m=x; 
               cn = 1; 
            }
            
            
        }
return cn;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] ar = new int[n];

        String[] arItems = scan.nextLine().split(" ");

        for (int arItr = 0; arItr < n; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = birthdayCakeCandles(n, ar);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
    }
}
