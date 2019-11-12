import java.lang.Exception;
import java.util.List;

public class GraphImplementation implements Graph
{
    private int[][] matrix;

    public GraphImplementation(int vertices)
    {
        matrix = new int[vertices][vertices];
    }

    void addEdges(int src, int tar) throws Exception
    {
        if(src < 0 || src > matrix.length || tar < 0 || tar > matrix.length)
        {
            throw new Exception("bruh are u srs");
        }
        matrix[src][tar] = 1;
    }
    
    List<Integer> neighbors(int vertex)
    {

    }
}