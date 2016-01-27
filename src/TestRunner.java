/**
 * Created by bharatbatra on 1/10/16.
 */
public class TestRunner {

    public static void main(String args[])
    {
        LRU<Integer,String> lru = new LRU<>(5);

        lru.put(1,"A");
        lru.put(2,"B");
        lru.put(3,"C");
        lru.put(4,"D");
        lru.put(5,"E");

        System.out.println("LINE 1" + lru.toString());
        lru.get(2);
        System.out.println("LINE 2" + lru.toString());
        lru.get(2);
        System.out.println("LINE 3" + lru.toString());
        lru.get(1);
        System.out.println("LINE 4" + lru.toString());
        lru.put(6, "X");
        System.out.println("LINE 5" + lru.toString());
        lru.get(1);
        System.out.println("LINE 6" + lru.toString());
        lru.get(4);
        System.out.println("LINE 7" + lru.toString());
        lru.put(7, "Y");
        System.out.println("LINE 8" + lru.toString());
        lru.put(8, "W");
        System.out.println("LINE 9" + lru.toString());
        lru.put(9, "Z");
        System.out.println("LINE 10" + lru.toString());


    }

}
