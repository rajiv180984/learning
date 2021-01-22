package com.first.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CieserCyper {

    static String caesarCipher(String s, int k) {
        // Complete this function
        int n = s.length();
        int j = 0;
        char res[] =new char[n];
        for(int i=0; i<n;i++){
            int val = (int)s.charAt(i);
            System.out.println("val :"+val);
            if(val>64 && val<91){
               val = val+ k;
                if(val>90){
                    val = val-90+65;
                    res[j] = (char)val;

                }
                else{

                    res[j]=(char)val;
                }
            }
            if(val>89 && val<123){
               val = val+ k;
                if(val>122){
                    val = val-122+90;
                    res[j] = (char)val;

                }else{
                    res[j]=(char)val;
                }


            }
            j++;
        }

        return new String(res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }
}
