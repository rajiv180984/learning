package com.first.com.first.arrays;

import java.util.Stack;

public class ParanthesisSolution {
    public static void main(String aa[]){
      String par = "{[{()}] []}";
      java.util.Stack<Character> stk = new Stack<>();
      for (int i=0; i<par.length();i++){
          char c = par.charAt(i);
          if(c=='{' || c=='[' || c == '('){
              stk.push(c);
          }else {
              char t = stk.peek();
              if ((c == '}' && t == '{') | (c == ']' && t == '[') | (c == ')' && c == '(')) {
                  stk.pop();
              }
          }

      }
      if(stk.isEmpty()){
          System.out.println(" Balanaced");
      }else{
          System.out.println("!!! Not Balanaced");
      }
    }

}
