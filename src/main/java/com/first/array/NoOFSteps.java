package com.first.array;

public class NoOFSteps {
    public static void main(String aa[]){
 NoOFSteps st = new NoOFSteps();
 int count = st.steps(10,3,2,0);
        System.out.println(count);
    }

    public int steps(int n, int x, int y, int sum){
        if(n==0){
            return 0;
        }
        if((n-x)%x==0){
            sum+=1;

           steps(n-x, x, y, sum);
        }else if((n-y)%y==0) {
            sum+=1;
           steps(n-y, x, y, sum);
        }/*else if( n<=2|| n<=3){
         // return sum+=1;
        }*/
        System.out.println(":"+sum);
return sum;
    }
}
