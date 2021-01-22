
package com.first.sort;


public class MergeSortIncreaseAndDecrease {
	public static void main(String[] args) {
		  int a[] = {20,30,40,50,55};
		  int b[] = {20, 14, 5, 3};
		  
		  int res[] = new int[a.length+ b.length];
		  int i=0; 
		  int j=b.length-1;
		  int k=0;
		  
		  
		  
		  while(i<a.length && j>=0) {
			  if(a[i]<b[j]) {
				  res[k] = a[i];
				  i++;
			  }else {
				  res[k] = b[j];
				  j--;
			  }
			  k++;
		  }
		
		  while(i<a.length) {
			  res[k++] = a[i++];
			  }
		  
		  while(j>=0) {
			  res[k++] = a[j--];
			  
		  }
		  
		  for(int r: res) {
			  System.out.print("--"+r);
		  }
		}
		
		 
}
