package com.first.string;

public class CommonCharecterAndFormStringWithUniqueChar {
    public static void main(String aa[]){
        System.out.println(""+(int)'a');
        String s1 = "abcdg";
        String s2 ="azcgya";
        int n= s1.length();
        int m=s2.length();
        int count[] = new int[26];
        for(int i=0; i< n||i<m;i++){
            if(i<n)
                count[s1.charAt(i) - 97]++;
            if(i<m)
            count[s2.charAt(i)-97]++;
        }
        String res="";
        for(int i=0; i<26;i++){
            if(count[i]==1){
                res = res.concat(String.valueOf((char)(i+97)));

            }
        }
        System.out.println(res);
    }
}
