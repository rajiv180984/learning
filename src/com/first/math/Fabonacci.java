package com.first.math;

public class Fabonacci {
  
	public static void main(String[] args) {
		int n =5;
		fabonaci(n);
		fabonacciByDP(n);
		
		fabonacciByRecursionDemo(n);
	}

	private static void fabonacciByRecursionDemo(int n) {
		// TODO Auto-generated method stub
		for(int i=1; i<=n; i++) {
			System.out.print(","+fabonacciByRecursion(i));
		}
		
	}

	private static int fabonacciByRecursion(int n) {
		// TODO Auto-generated method stub
		if(n==1 || n==2) {
			return 1;
		}
		return fabonacciByRecursion(n-1) + fabonacciByRecursion(n-2);
		
		
	}

	private static void fabonacciByDP(int n) {
		// TODO Auto-generated method stub
		System.out.println("\n Fabonacci Series by DP");
		int dp[] = new int[5];
		
		dp[0] = 1;
		dp[1] =1;
		for(int i=2; i<n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		for(int i:dp) {
			System.out.print(i+" ,");
		}
	}

	private static void fabonaci(int n) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 1;
		System.out.print(a+" , "+b);
		for(int i=2; i<n ; i++) {
			int c = a+b;
			a = b;
			b=c;
			System.out.print(" , "+c);
		}
	}
}
