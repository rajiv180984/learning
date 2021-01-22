package com.first.dp;

public class PalindromEditOPs {
    public static void main(String aa[]){
        String s1 = "abcde";
        int ops = palindromFormEditOps(s1.toCharArray(), 0, s1.length()-1);
        System.out.println("Number of Ops :"+ops);
    }

    public static int palindromFormEditOps(char s[], int start, int end){
        // String with only one char
        if(start == end){
            return 0;
        }
        // String with only two char, check even palindrom or not.
        if (start == end -1|| s.length==2){
            if(s[start]== s[end]){
                // not add operation
                return 0;
            }else {
                // add one char
                return 1;
            }
        }

        if(s[start] == s[end]){
            // check next combination/ shrink string
            return palindromFormEditOps(s,start+1, end-1);
        }
        // let say Strig "bcde" So one branch: bcd , cde third is middle 2 or 1 char
        return Math.min(palindromFormEditOps(s, start+1, end),palindromFormEditOps(s, start, end-1))+1;
    }
}
