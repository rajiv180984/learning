package com.first.dp;

public class CuttingRope {
    public static void  main(String aa[]){
        System.out.println(cuttingRope(10));
    }

    public static int cuttingRope(int n){
        if(n==0 || n==1){
            return 0;
        }
        // check i=1,....n
        int res=0;
        for(int i=1; i<n;i++) {
            // assume cut at ith position
            // case 1: at position ith location product will be maximum (n-i)*i
            // or max product lies in remaining part (n-i)*i
            int max = Math.max((n - i)*i, cuttingRope(n-i)*i);
             res = Math.max(res, max);
        }
return res;
    }
}
