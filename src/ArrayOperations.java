import java.util.ArrayList;

/**
 * Created by bharatbatra on 1/19/16.
 */
public class ArrayOperations
{
    static int[] T = {2,9,3,10,1,23,7,0,4};

    public static void main(String args[])
    {

        printArray(T);

        printArray(mergeSplit(T));
    }

    public static void printArray(int[] A)
    {
        StringBuilder builder = new StringBuilder();
        for (int i : A) {
            builder.append(i + " ");
        }
        String text = builder.toString();
        System.out.println(text);
    }


    public static int[] mergeSplit(int[] A)
    {

        int mid = A.length/2;
        if(mid==0)
            return A;
        int[] aLeft = new int[mid];
        int[] aRight = new int[A.length-mid];

        int counter = 0;
        for(int i=0; i<aLeft.length; i++)
            aLeft[i]=A[counter++];
        for(int i=0; i<aRight.length; i++)
            aRight[i]=A[counter++];



        return mergeSort(mergeSplit(aLeft), mergeSplit(aRight));

    }

    public static int[] mergeSort(int[] A, int[] B)
    {

        int i =A.length,j = B.length;
        if(i==0||j==0)
          return i>j?A:B;
        int[] M = new int[A.length+B.length];
        int counter = 0,k=0,l=0;
        while(counter<M.length)
        {
            try
            {

                if(A[k]<=B[l])
                    M[counter] = A[k++];
                else
                    M[counter] = B[l++];

            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                if(k<i)
                    M[counter] = A[k++];
                else if(l<j)
                    M[counter] = B[l++];
            }
            counter++;
        }
        System.out.print("M : ");
        printArray(M);
        return M;

    }
}
