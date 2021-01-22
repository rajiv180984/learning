package com.first.string;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class PanagramSolution{

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
                pan[x-97]++;
            }

        }

        for(int i=0; i<26;i++){
            if(pan[i]==0){
                return "not pangram";
            }
        }

        return "pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
