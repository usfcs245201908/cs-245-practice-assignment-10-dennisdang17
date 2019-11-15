import java.lang.Exception;
import java.util.*;

public class GraphImplementation implements Graph
{
    private int[][] matrix; //our graph
    private int vertices; //total number of vertices

    public GraphImplementation(int totalVertices) //constructor
    {
        vertices = totalVertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int v1, int v2) throws Exception 
    {
        if(v1 >= vertices || v1 < 0 || v2 >= vertices || v2 < 0)
        {
            throw new Exception(); //throw exception for invalid target
        }

        matrix[v1][v2] = 1; //set two vertices to 
    }

    public List<Integer> topologicalSort()
    {
        System.out.print("Solution: ");
        List<Integer> solution = new ArrayList<>(); //list of the 

        int[] sum = new int[matrix.length];
        for(int i = 0; i<vertices; i++)
        {
            for(int j=0; j<vertices; j++)
            {
                sum[i] += matrix[j][i]; //populates the sum array with the sum of the columns
            }
        }

        for(int count=0; count<vertices; count++)
        {
            int n = findZero(sum); // finds the next 0 in the sum array to add to the solution array
            if(n == -1) //if no possible solution, return right away.
            {
                System.out.println("\nAn ordering of this graph is not possible."); //check to see if no possible 
                return solution;
            }
            solution.add(n);
            System.out.print(n+" ");
            sum[n] = -1; //flags the item as visited
            for(int i=0; i<vertices; i++)
            {
                sum[i] -= matrix[n][i]; // resets the sum array after adding n to the solution list
            }
        }
        System.out.println(); //formatting
        return solution;
    }

    public List<Integer> neighbors(int vertex) throws Exception
    {
        if(vertex >= vertices || vertex < 0)
        {
            throw new Exception();//throws exception if vertex does not exist
        }
        List<Integer> neighbors = new ArrayList<>(); //list of neighbors to vertex
        for(int i=0; i<vertices; i++) //goes through row
        {
            if(matrix[vertex][i] > 0)
            {
                neighbors.add(i); //if there is a edge between the two, add it into list
            }
        }
        return neighbors;
    }

    private int findZero(int[] sum)
    {
        for(int i=0; i<vertices; i++)
        {
            if(sum[i] == 0)
            {
                return i; //return the next zero in the sum array
            }
        }

        return -1;//if cant be found return -1
    }
}