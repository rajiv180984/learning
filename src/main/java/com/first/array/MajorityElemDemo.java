package com.first.array;

// majority element mean element occurance is more more than N/2
// So at the end element count shoud be greater than 1
// assume any element might be major, take count, if same element occure increase count or reduce count by 1
// if count became zero means so, far there is no major element. again we need to initialize it.
public class MajorityElemDemo {

    public static void main(String aa[]){
        int a[] = {3,4,5,3,4,7,8,4,4,9,9,10,4,4,4};
        int cout = majorityElem(a);
        System.out.println(cout);
    }

    public static int majorityElem(int a[]){
        int maz = a[0];
        int count = 1;
        for(int i=0; i< a.length;i++){
            if(maz == a[i]){
                count++;
            }else {
                count --;
            }
            if (count == 0){
                maz = a[i];
                count =1;
            }
        }
        if(count>1){
            return maz;
        }else {
            System.out.println(" No major element ");
            return -1;
        }
    }

}
