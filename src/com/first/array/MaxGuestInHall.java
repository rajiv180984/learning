package com.first.array;

public class MaxGuestInHall {
    public static void main(String aa[]) {

        int arrl[] = {13,28,29,14,40,17,3};
        int exit[] = {107,95,111,105,70,127,74};

        int guest=1;
        int max_guest=0;
        int i = 0;
        int j=1;
        while (i < arrl.length & j<arrl.length){
            // if exit time is less than or equal than count guest by 1
            if(arrl[j]<=exit[i]){
                guest++;
                j++;
            }else {
                // guest is out
                guest --;
                i=j;
                j++;
            }
            if(guest==0){
                i=j-1;
            }
        }
        System.out.println(" Number of guest "+guest);
    }
}
