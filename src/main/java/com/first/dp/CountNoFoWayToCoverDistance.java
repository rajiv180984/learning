package com.first.dp;

public class CountNoFoWayToCoverDistance {
    public static void  main(String aa[]){
        System.out.println(wayToCoverDistance(10));
    }

    private static int wayToCoverDistance(final int n) {
        int count[] = new int[n+1];
        if(n==0 || n==1){
            return 1;
        }
        // index in count store the number of way to for distance [Distance = index]
        // 0th distance 1; 1st distance only one way and 2nd distance only two way 1,1 or 2
        count[0]=1; count[1]=1; count[2]=2;
        for(int i=3;i<=n;i++){
            count[i] = count[i-1]+count[i-2]+count[i-3];

        }
        return count[n];
    }

}
