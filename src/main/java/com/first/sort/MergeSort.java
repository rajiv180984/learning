package com.first.sort;

public class MergeSort {

	public static void main(String[] args) {
	  int a[] = {2,10,14,20,35};
	  int b[] = {10, 14, 15, 20};
	  
	  int res[] = new int[a.length+ b.length];
	  int i=0; 
	  int j=0;
	  int k=0;
	  while(i<a.length && j<b.length) {
		  if(a[i]<b[j]) {
			  res[k] = a[i];
			  i++;
		  }else {
			  res[k] = b[j];
			  j++;
		  }
		  k++;
	  }
	
	  while(i<a.length) {
		  res[k++] = a[i++];
		  }
	  
	  while(j<b.length) {
		  res[k++] = a[j++];
		  
	  }
	  
	  for(int r: res) {
		  System.out.print("--"+r);
	  }
	}
	
	
	
}
