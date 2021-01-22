package com.first.string;

public class RemoveAdjDup {
    public static void main(String aa[]){

    }

    public char[] removeDuplicate(char s[], int i, int n, int count){
        if(i==n-2){
            return s;
        }

        if(s[i]==s[i+1]){
            s[i-1]=s[i+1];
            count+=2;
        }
        return s;
    }
}
