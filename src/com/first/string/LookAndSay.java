package com.first.string;

public class LookAndSay {
	public static void main(String[] args) {
		String s2 ="1";
	   int n =7;
	 lookandSay( n);
	 // String s1 = lookAndSayLevel(s2);
	  //System.out.println(s1);
	}

	private static void lookandSay(int n) {
		// TODO Auto-generated method stub
		String lns = "1";
		for( int i=0; i<n; i++) {
			System.out.println(lns);
			lns = lookAndSayLevel(lns);
			
		}
		
	}

	private static String lookAndSayLevel(String s2) {
		// TODO Auto-generated method stub
		int c =1;
		String result = "";
		for(int i=0; i<s2.length(); i++) {
			c =1;
			char localchar = s2.charAt(i);
			for(int  j=i; j<s2.length(); j++) {
			
				if(j+1<s2.length() && (s2.charAt(j) == s2.charAt(j+1))) {
					c++;
				}else {
					break;
				}
				
			}
			i=i+c-1;
			result = result.concat(String.valueOf(c).concat(String.valueOf(localchar)));
			// edege case
			//System.out.println("Hello :"+result);
		}
		return result;
	}
	
}
