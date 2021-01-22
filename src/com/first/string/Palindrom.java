package com.first.string;

public class Palindrom {
    public static void main(String aa[]) {
        System.out.println(isPalindrom("geeksskeeg"));
        System.out.println(longestPalindromSubString("forgeeksskeegfor"));
    }

    public static boolean isPalindrom(String s1) {

        int n = s1.length();
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            if (s1.charAt(low) != s1.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static String longestPalindromSubString(String s1) {
        String s = null;
        int n = s1.length();
        int maxLen =0;
        String evenPalindrom="";
        String oddPalindrom = "";
        String maxPalStr="";
        for (int i = 1; i < n; i++) {

          evenPalindrom =  evenPalindrom(s1,i, true);
          oddPalindrom =  evenPalindrom(s1,i, false);
          if(evenPalindrom.length()> oddPalindrom.length()){
              if(maxLen<evenPalindrom.length()){
                  maxLen = evenPalindrom.length();
                  maxPalStr= evenPalindrom;
              }

          }else {
              if(maxLen<oddPalindrom.length()){
                  maxLen = oddPalindrom.length();
                  maxPalStr= oddPalindrom;
              }
          }

        }
        return maxPalStr;

    }

    private static String evenPalindrom(String s1, final int i, boolean isEven) {
      int low;
      int high;
      String palindromStr="";
       if(isEven){
           low = i-1;
           high = i;
           palindromStr= String.valueOf(s1.charAt(i));
       }else {
           low = i-1;
           high = i+1;
       }

       while(low>=0 && high<s1.length()) {
           if(s1.charAt(low)== s1.charAt(high)){
                low--;
                high++;
           }else {
               break;
           }
       }
      return s1.substring(low+1,high);

    }
}
