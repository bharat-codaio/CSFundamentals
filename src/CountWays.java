import java.util.ArrayList;

/**
 * Created by bharatbatra on 1/2/16.
 */
public class CountWays
{
    public static void main(String args[])
    {
        int n = 5;
        int[] map = new int[n+1];
        for(int i=0; i<=n; i++)
            map[i] = -1;
        ArrayList<Integer> sequence = new ArrayList<>();
        int total = countCoinWays(n,map,sequence);
        System.out.println(total);


    }

    public static int countCoinWays(int n, int[] map, ArrayList<Integer> seq)
    {
      if(n<0){
      	seq.remove(seq.get(seq.size()-1));
        
            return 0;
      }
        else if(n==0)
        {
          
        
            System.out.println(seq.toString());  seq.clear();
            return 1;
        }
        else if(map[n]>-1)
        {
         
            return map[n];
        }
        else
         
        {
         
            map[n] = countCoinWays(n-1, map, appendToSeq(seq,1)) + countCoinWays(n-5, map, appendToSeq(seq,5))
                    + countCoinWays(n-10, map, appendToSeq(seq,10))  + countCoinWays(n-25, map, appendToSeq(seq,25)) ;//currently it is calculating the order
            return map[n];
        }
    }

    private static ArrayList<Integer> appendToSeq(ArrayList<Integer> seq, int element)//will be replaced by private add method
    {
        seq.add(element);
        return seq;
    }

    private class Split
    {
        int pennies, dimes, nickels, quarters; //this class can be used to ensure that only unique combinations are counted.

    }
}
