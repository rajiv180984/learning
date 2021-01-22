package com.first.array;

import java.util.ArrayList;
import java.util.List;

public class TimeOverlappingDemo {
    public static void main(String aa[]) {
        System.out.println("============ ");
        List<Range> timeSet = new ArrayList<>();
        timeSet.add(new Range(1,3));
        timeSet.add(new Range(3,4));
        timeSet.add(new Range(4,5));
        timeSet.add(new Range(5,6));
        timeSet.add(new Range(6,7));
        TimeOverlappingDemo timeovp = new TimeOverlappingDemo();
        timeovp.maximumOverlapping(timeSet);
    }
    // approach 2: sort eac time interval with the start time and compare fist with next one
    // end of i-1 should be greater than ith start time

    public void maximumOverlapping(List<Range> timeSet) {
     Range time[] = new Range[10];
     int maxCount =-1;

        for(int i=0; i<timeSet.size();i++){
            Range temp = timeSet.get(i);
            int count =0;
            for(int j=1; j<timeSet.size();j++){
                if(i==j){
                    continue;
                }
                if (timeSet.get(j).start<temp.end && timeSet.get(j).end>temp.start){
                    count++;
                }
            }
if(maxCount<count){
                maxCount = count;
}
        }
        System.out.println(" Max Plateform :"+ maxCount);
    }



}
class Range{
    public int start;
    public int end;

    public Range(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

}

