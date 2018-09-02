package com.fico.second.graph;
/* Java program for solution of M Coloring problem
   using backtracking */
public class GraphColoring {
    final int V = 4;
    int color[];

    /* A utility function to check if the current
       color assignment is safe for vertex v */
   public boolean isSafe(int vertex, int graph[][], int color[], int colorNum ){

       for(int i=0;i<V;i++){
           // source node and exected next color to paint on adj is same then it is not safe to color
           if(graph[vertex][i]==1 && color[vertex]== colorNum ){
               return false;
           }
       }
       return true;
   }

   public boolean graphColoring(int graph[][], int m, int color[], int v){
        // recursively check each color
       // when all node visited and colored then return true
       if(v==V){
           return true;
       }
       // check perticular color is valid to color
       for (int c =1 ;c<m; c++){
           if(isSafe(v, graph, color,c)){
               // if safe then check adj node with another color
               // color will be opted for coloring
               color[v] = c;
               // check for next node
               if(graphColoring(graph,m, color, v+1)){
                   return true;
               }
               // try with another solution
                   color[v] =0 ;

           }
       }
       return false;
   }
    /* A recursive utility function to solve m
       coloring  problem */
    boolean graphColoringUtil(int graph[][], int m,
            int color[], int v)
    {
        /* base case: If all vertices are assigned
           a color then return true */
        if (v == V)
            return true;

        /* Consider this vertex v and try different
           colors */
        for (int c = 1; c <= m; c++)
        {
            /* Check if assignment of color c to v
               is fine*/
            if (isSafe(v, graph, color, c))
            {
                color[v] = c;

                /* recur to assign colors to rest
                   of the vertices */
                if (graphColoringUtil(graph, m,
                        color, v + 1))
                    return true;

                /* If assigning color c doesn't lead
                   to a solution then remove it */
                color[v] = 0;
            }
        }

        /* If no color can be assigned to this vertex
           then return false */
        return false;
    }

    /* This function solves the m Coloring problem using
       Backtracking. It mainly uses graphColoringUtil()
       to solve the problem. It returns false if the m
       colors cannot be assigned, otherwise return true
       and  prints assignments of colors to all vertices.
       Please note that there  may be more than one
       solutions, this function prints one of the
       feasible solutions.*/
    boolean graphColoring(int graph[][], int m)
    {
        // Initialize all color values as 0. This
        // initialization is needed correct functioning
        // of isSafe()
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        // Call graphColoringUtil() for vertex 0
        if (!graphColoringUtil(graph, m, color, 0))
        {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution(color);
        return true;
    }

    /* A utility function to print solution */
    void printSolution(int color[])
    {
        System.out.println("Solution Exists: Following" +
                " are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }

    // driver program to test above function
    public static void main(String args[])
    {
        GraphColoring Coloring = new GraphColoring();
        /* Create following graph and test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        int m = 3; // Number of colors
        Coloring.graphColoring(graph, m);
    }
}