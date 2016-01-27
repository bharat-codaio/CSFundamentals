import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by bharatbatra on 12/14/15.
 */
public class Test {

    public Test()
    {
        printMe();
    }

    void printMe()
    {
        System.out.println(this.getClass());
    }
    public static void main(String args[]) {
//        int width = 3;
//        int height = 4;
//        char x[][] = new char[width][height];
//        Random r = new Random();
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                x[i][j] = '0';
//            }
//        }
//
//        for (int i = 0; i < r.nextInt(width * height / 2); i++) {
//            x[r.nextInt(width)][r.nextInt(height)] = 'X';
//        }
//
//        x[r.nextInt(width)][r.nextInt(height)] = '1';
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                System.out.print(x[i][j]);
//            }
//            System.out.println("");
//        }
//
//        int startX = r.nextInt(width);
//        int startY = r.nextInt(height);
//
//        x[startX][startY]= 'P';
//
//        boolean found = false;
//
//        while(!found)
//        {
//            try {
//                int nextX = startX + 1;
//                int nextY = startY;
//
//                if (nextX < width && nextY < height && (x[nextX][nextY] == '0' || x[nextX][nextY] == '1')) {
//                    if (x[nextX][nextY] == '1') {
//                        found = true;
//                    }
//
//                    x[nextX][nextY] = 'P';
//                }
//                nextX = startX - 1;
//                nextY = startY;
//
//                if (nextX < width && nextY < height && (x[nextX][nextY] == '0' || x[nextX][nextY] == '1')) {
//                    if (x[nextX][nextY] == '1') {
//                        found = true;
//                    }
//
//                    x[nextX][nextY] = 'P';
//                }
//
//                nextX = startX;
//                nextY = startY - 1;
//
//                if (nextX < width && nextY < height && (x[nextX][nextY] == '0' || x[nextX][nextY] == '1')) {
//                    if (x[nextX][nextY] == '1') {
//                        found = true;
//                    }
//
//                    x[nextX][nextY] = 'P';
//                }
//
//                nextX = startX;
//                nextY = startY + 1;
//
//                if (nextX < width && nextY < height && (x[nextX][nextY] == '0' || x[nextX][nextY] == '1')) {
//                    if (x[nextX][nextY] == '1') {
//                        found = true;
//                    }
//
//                    x[nextX][nextY] = 'P';
//                }
//            }catch(ArrayIndexOutOfBoundsException e)
//            {
//
//
//            }
//        }
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                System.out.print(x[i][j]);
//            }
//            System.out.println("");
//        }

        Test t = new Test();
        TestChild tc = new TestChild();
    }



}

class TestChild extends Test
{
    public TestChild()
    {
        super();
    }
}

/*
    Employee - > {respondant, manager, attendant}
    {
    bool free;
    }
    ... EmployeeFactory


    Call
    {

    }
 */