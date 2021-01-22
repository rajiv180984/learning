package com.first.array;

public class GlassWaterProblem {
    public static void main(String aa[]){
        float x = (float)20/3;
        System.out.println(x);
        System.out.println();

        fillWaterInGlasses(1.f, 10.0f);
    }
    // n is level
    public static int[] glassWater(int n, int X){
          int glass[] = new int[(n*(n+1)/2)];

            // start adding X water in 0th class;
          int index =0;

          //for(int i=1;i<n; i++)


          return glass;
    }

   public static int fillWaterInGlasses(float C, float N)
    {
        // Pour total water in top glass initially.
        float glasses[][] = new float[5][5];
        glasses[0][0] = N;
        int level=0;
        boolean waterInLevel = true;
        while(waterInLevel)
        {
            waterInLevel = false;
            // For each glass in the level.
            for(int j=0; j<=level; j++)
            {
                // If the glass has more liquid then it can store
                // then pour it to glasses under it.
                // for each glass at same level having extra water should pour to next level
                // once each glass at this level visited and move extra water then move to next level
                if(glasses[level][j] > C)
                {
                    double extraWater = glasses[level][j] - C;
                    glasses[level][j] =(int) C;
                    glasses[level+1][j] +=(float) extraWater / 2;
                    glasses[level+1][j+1] += (float)extraWater / 2;
                    waterInLevel = true;
                }
            }
            level++;
        }

        for (int i=0; i<5; i++){
            System.out.println();
            for (int j=0; j<5; j++){
                System.out.print("  "+glasses[i][j]);
            }
        }

        return level-1;
    }
}
