package com.collection;

import java.util.Comparator;

public class ActivitySort implements Comparator<Activity> {
    @Override
    public int compare(final Activity o1, final Activity o2) {
        if( o1.getEnd()<= o2.getEnd()){
            return -1;
        }else {
            return 1;
        }
    }
}


