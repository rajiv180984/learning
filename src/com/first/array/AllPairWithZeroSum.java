package com.first.array;

public class AllPairWithZeroSum {

    public static void main(String aa[]){
        int a[] =  {6, 3, -1, -3, 4,6, -2, 2,
                4, 6, -12, -7};
        int sum =0;
        int count =0;
        int Im=0;
        for(int i=0; i<a.length;i++){
            sum =0;
            for(int j=0; i+j<a.length;j++){
                sum+=a[i+j];
                if(sum == 15){
                    System.out.println(i+" and "+(i+j));

                    if(j+1>count){
                        count = j+1;
                        Im =i;
                    }
                }
            }
        }
        System.out.println("Start from "+Im+ " and :"+(Im+count-1));
    }

}
