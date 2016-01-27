import java.util.ArrayList;

/**
 * Created by bharatbatra on 1/11/16.
 */
public class NQueens
{
    public static void main(String args[])
    {
        ArrayList<Integer[]> results = new ArrayList<>();
        int row = 0;
        Integer columns[] = new Integer[size];
        placeQueens(results,row,columns);
    }

    static int size = 4;
    public static void placeQueens(ArrayList<Integer[]> results, int row, Integer columns[])
    {
        if(row==size)
        {
            results.add(columns.clone());
            printBoard(columns);
        }

        else
        {
            for(int i=0; i<size; i++)
            {
                if(isValid(row, i, columns))
                {
                    columns[row] = i;
                    placeQueens(results, row+1, columns);
                }
            }
        }
    }

    public static boolean isValid(int row, int col, Integer columns[])
    {
        for(int i = 0; i<row; i++)
        {
            if(col==columns[i])
                return false;
            if(row-i==Math.abs(col-columns[i]))
                return false;
        }
        return true;
    }

    public static void printBoard(Integer columns[])
    {
        System.out.println("Possible Board:");
        for(int r=0; r<size; r++)
        {
            for(int c = 0; c<size; c++)
            {
                if(columns[r]==c)
                    System.out.print("Q");
                else System.out.print(1);
            }
            System.out.println();
        }
    }
}
