package com.first.string;
public class GemstonesSoluion {

	public static void main(String[] args) {
		String arr[] = {"abcdde","baccd","eeabg"};
		int x =gemstones(arr);
		System.out.println("========= "+ x);
	}
    // Complete the gemstones function below.
    static int gemstones(String[] arr) {

          int ch[] = new int[26]; 
          int l = arr.length;
          for(int i=0;i<26;i++){
                  
                  ch[i]=-1;
                  
              }
              for(int i=0;i<arr[0].length();i++){
                  
                  ch[(int) arr[0].charAt(i)-97]=1;
                  System.out.print("--"+((int) arr[0].charAt(i)-97));
              }
             for(int i: ch){
                 
                 System.out.print(i);
                 
             }
              
          for(int i=1;i<arr.length;i++){
              int x= arr[i].length();
              String s = arr[i];
              for(int j=0;j<26;j++){
                  if(ch[j]>=1){
                      char c = (char) (j+97);
                      if(s.indexOf(c)<0) {
                    	  ch[j]=-1;
                      }
                  }
                  
              }
          }
          int gem =0;
          for(int i:ch){
              if(i>0){
                  gem++;
              }
          }
          return gem;
    }
}
