package com.first.com.first.arrays;

public class RearrangePositiveandNegativeNumbers {

    public static void main(String aa[]) {
        int data1[] = {5, -2, 8, 3, -25, -15, -6, 8, 11};

        System.out.println("========================");
        reaarnageNumber(data1);
    }

    public static void reaarnageNumber(int data[]){

        int i=0; int j = data.length-1;
        while (i<j){
            if(data[i]>=0 && data[j]<0){
                int t = data[i];
                data[i] = data[j];
                data[j] = t;
            }else if(data[i]<0){
                i++;
            }else{
                j--;
            }
        }
for(int x: data){
    System.out.print("=="+x);
}
    }
}
