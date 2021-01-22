package com.first.dp;

public class PartitionSetOfNumeber {

    public int setofParition(int num, int part){
        if(num == 0 || part == 0 || num<part){
            return 0;
        }
        if(num == 1 || num == part){
            return 1;
        }
        return part*setofParition(num-1,part)+setofParition(num-1,part-1);
    }
}
