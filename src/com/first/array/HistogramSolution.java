package com.first.array;

import java.util.Stack;

public class HistogramSolution {

    public static void main(String aa[]){
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + maxAreaOfHist(hist));
    }

    public static int maxAreaOfHist(int hist[]){
        int n = hist.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int area =0;
        int i=0;
        while (i<n){

            // insert index if bar at this index is equal or greater than stack top or Stack is empty
            if(st.empty()|| hist[st.peek()]<=hist[i]){
                st.push(i);
                i++;
            }else {
                int tp = st.pop();
                area = hist[tp]*( st.empty()? i: i-st.peek()-1);
                if(area > maxArea){
                    maxArea = area;

                }

            }

        }

        while (st.empty()){
            int tp = st.pop();
            area = hist[tp] * (st.empty()? i :i-st.peek()-1);
            if(area > maxArea){
                 maxArea = area;
            }
        }
        return maxArea;
    }
}
