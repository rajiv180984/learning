package com.fico.second.graph;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


// DFS Rule:
// 1. When visited push into Stack before pushing check the list of processed node. If already Processed no need
// further processsing and push into stack
// 2. When
public class DirectedConnectivityDfs
{
    private Stack<Integer> stack;

    public DirectedConnectivityDfs()
    {
        stack = new Stack<Integer>();
    }

    public int[] dfs(int adjacency_matrix[][], int source)
    {
        List<Integer> path = new LinkedList<>();
       int noOfNodes = adjacency_matrix.length;
       int visited[] = new int[noOfNodes];
       stack.push(source);
       visited[source] =1;

       while (!stack.isEmpty()){

           int curr = stack.pop();
           visited[curr] = 2;
           path.add(curr);
           System.out.print("-->"+curr);
           for (int j=0; j<noOfNodes; j++){
               if(adjacency_matrix[curr][j]== 1 && visited[j] ==0){
                   stack.push(j);
                   visited[j] =1;
                  // System.out.println(stack.size());
               }
           }
       }

return visited;
    }

    public int irelandUtil(int adjacency_matrix[][], int source ){
        int []visited = new int[adjacency_matrix.length-1];

        int count = 0;
        for(int i=0;i<adjacency_matrix.length-1; i++){
            if(visited[i]==0){
                System.out.println(" Source :"+i);
                visited = dfs(adjacency_matrix, i);
                count++;

            }
        }
return count;
    }
    public void findIreland(int adjacency_matrix[][], int source, int []visited){


    }
    public static void main(String...arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();

            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 0; i < number_of_nodes; i++)
                for (int j = 0; j < number_of_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();

            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();

            DirectedConnectivityDfs directedConnectivity= new DirectedConnectivityDfs();
            directedConnectivity.dfs(adjacency_matrix, source);
            System.out.println("---------------------------------");
            int i = directedConnectivity.irelandUtil(adjacency_matrix, source);
            System.out.println("===="+i);

        }catch(InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }
}