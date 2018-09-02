package com.first.dp;

public class EggDrop {

    public int floorNum(int eggNo, int floorNo) {

        if (floorNo == 0 || floorNo == 1) {
            return floorNo;
        }

        if (eggNo == 1) {
            // max floow;
            return floorNo;
        }

        int mxFloor = -1;
        int res=10000;
        for (int i = 1; i <= floorNo; i++) {
            mxFloor =  Math.max(floorNum(eggNo - 1, i - 1), floorNum(eggNo, floorNo - i));
            if(mxFloor<res){
                res = mxFloor;
            }
        }
        return res+1;
    }
}