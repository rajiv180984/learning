package com.first.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CamelcaseSolution {

    static int camelcase(String s) {
        int n = s.length();
        //System.out.println(n);
        int i=0;
        int j=0;
        int k=0;
        String res[]= new String[n];
        do{
            
          if((int)s.charAt(j)<91 && (int)s.charAt(j)>64 ){
           System.out.println(k+" "+s.substring(i, j));  
              k++;
              i=j;
          }  
            j++;
        }while(i<n && j<n);
        // last String
        System.out.println(k+" "+s.substring(i, n));
        return k+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}
