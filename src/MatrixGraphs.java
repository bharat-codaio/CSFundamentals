/**
 * Created by bharatbatra on 1/11/16.
 */
public class MatrixGraphs
{
    static int rows = 5;
    static int cols = 5;
    public static void main(String args[])
    {
        int[][] world = {{1,0,0,0,0},{0,1,1,1,0},{0,1,1,0,1},{1,0,0,1,1},{1,1,1,1,1}};
        largestIsland(world);
    }

    public static boolean isSafe(int[][] world, boolean[][] visited, int r, int c)
    {
        return (r>=0&&r<rows&&c>=0&&c<cols &&visited[r][c]==false && world[r][c]==1);
    }

    public static int DFScount(int[][] world, boolean[][] visited, int r, int c)
    {
        int sum = 0;
        if(world[r][c]==1)
            sum++;
        visited[r][c] = true;

        int nR[] = {-1,1,0,0};
        int nC[] = {0,0,-1,1};

        for(int i = 0; i<nR.length; i++)
        {
           if(isSafe(world, visited, r+nR[i], c+nC[i]))
               sum+= DFScount(world, visited, r+nR[i], c+nC[i]);
        }

        System.out.println("Island Sum = " + sum);
        return sum;
    }

    public static void largestIsland(int[][] world)
    {
        boolean[][] visited = new boolean[rows][cols];

        int max = 0;
        int numIslands = 0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0;j<cols; j++)
            {
                int count = DFScount(world, visited, i, j);
                if(count>max) {
                    max = count;
                    numIslands++;
                }

            }
        }

        System.out.println("Island Max = " + max);
        System.out.println("Island Nums = " + numIslands);

    }

}
