package com.first.string;

public class StringMatchingSolution {

    public static  boolean subString(String s, String s2) {
        int i = 0;
        char c = s.charAt(0);
        int index = s2.indexOf(c);
        if(s.length()!=s2.length()){
            return false;
        }
        while (i < s.length()) {
            if (s.charAt(i) != s2.charAt((i + index) % s.length())) {
                return false;
            }
            i++;
        }
        return true;

    }

    public static void main(String aa[]){
        boolean res = subString("ABACD", "DABAC");
        System.out.println("========= "+ res);
    }
}
