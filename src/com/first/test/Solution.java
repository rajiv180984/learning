
package com.first.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String pangrams(String s) {
        int []pan = new int[26];
        int n= s.length();
        s= s.toLowerCase();
        for(int i=0; i<26;i++){
            pan[i]=0;
        }
        for(int i=0; i<n;i++){
            int x= (int)s.charAt(i);
            if(x>96 && x<123){
                System.out.println("---------------"+x);
                int t = x-97;
                if(t<26) {
                    pan[t]++;
                }
            }

        }

        for(int i=0; i<26;i++){
            if(pan[i]==0){
                System.out.println(i);
                return "not pangram";
            }
        }

        return "pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String s = "We promptly judged antique ivory buckles for the next prize";

        String result = pangrams(s);
        System.out.println(result);

        int d[] = {5,8,2,28,20,15,4};
        int res[] = bubbleSort(d);
        for (int x: res
             ) {
            System.out.print("->"+x);
        }
    }

    public static int[] bubbleSort(int aa[]){
        int n = aa.length;
        for(int i=0; i<n;i++){
            for(int j=0; j<n-i-1;j++){
                if(aa[j]>aa[j+1]){
                    //swap
                    int t =aa[j];
                    aa[j]=aa[j+1];
                    aa[j+1] = t;
                }
            }
        }
        return aa;
    }

    static String[] bigSorting(String[] aa) {
        int n = aa.length;
        for(int i=0; i<n;i++){
            for(int j=0; j<n-i-1;j++){
                if(Long.parseLong(aa[j])>Long.parseLong(aa[j+1])){
                    //swap
                    String t =aa[j];
                    aa[j]=aa[j+1];
                    aa[j+1] = t;
                }
            }
        }
        return aa;


    }
}
