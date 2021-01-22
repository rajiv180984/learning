package com.first.dp;

public class DPDemo {
    public static void main(String aa[]){
        MaxGoldCollectionDP mgold = new MaxGoldCollectionDP();
        int gold[] = {20,3,1,2,13,5,2,7,8,1,1};
        int maxGold = mgold.maxGoldCalculate(gold);
        System.out.println(maxGold);
        System.out.println("Egg Tuta ya nahi ===");
        EggDrop egg = new EggDrop();
        int floor = egg.floorNum(2,10);
        System.out.println("Egg will break at floor :"+floor);

        System.out.println("Ugly Number or Fabonaci Num :");
        FibonacciNo fab = new FibonacciNo();
        System.out.println("Why is this Ugly num : "+fab.uglyNum(3));
        System.out.println("Why is this Ugly num : "+fab.fabonacciByDP(3));

        PartitionSetOfNumeber part = new PartitionSetOfNumeber();
        System.out.println("Partition Num :"+part.setofParition(2,1));


    }
}
