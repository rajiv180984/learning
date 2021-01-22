package com.first.stack;

import java.util.Stack;

public class SortStack {
    public static void main(String aa[]){
         Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(20);
        stack.push(1);
        stack.push(15);
        stack.push(7);
        sortStatckFun(stack);

    }

    public static Stack sortStatckFun( Stack<Integer> stack){

        // Apply selection sort approach first iteration find highest item place it at bottom
        // next second highest and place it in stack , iteration is n-1, n-2, n-3 and so on
        // stack is not empty
        Stack<Integer> tempStk = new Stack<>();
       // int x = stack.pop();
        int n = stack.size();
        for(int i =0; i<n; i++){
            // n-i time
            int x = stack.peek();
            for(int j=0; j<n-i; j++) {
                if (x < stack.peek()) {
                    x = stack.peek();
                }
                tempStk.push(stack.pop());
            }
            stack.push(x);
            while (!tempStk.isEmpty()){
                if(tempStk.peek()== x){
                    tempStk.pop();
                    // in case of mutiple num same
                    x = Integer.MIN_VALUE;
                }else {
                System.out.println(tempStk.size());
                stack.push(tempStk.pop());}
            }
        }

        System.out.println(stack.toString());
        return stack;
    }
}
