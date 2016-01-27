import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by bharatbatra on 12/31/15.
 */
public class LRU <K, V>{
    class Node<T, U>{
        T key;
        U value;
        Node<T,U> prev;
        Node<T,U> next;

        public Node(T t, U u)
        {
            this.key = t;
            this.value = u;
        }
    }

    int capacity;
    HashMap<K, Node<K,V>> hm = new HashMap<>();
    Node<K,V> head = null;//most recently used
    Node<K,V> tail = null;//least recently used

    public LRU(int size)
    {
        this.capacity = size;
    }

    public V get(K key)
    {
       Node<K,V> temp = hm.get(key);
        if(temp==null)
        {
            System.out.println("Debug = get key not found in cache");
            return null;
        }
        System.out.println("Debug = get key found in cache : "+  temp.value);
        foundInCache(temp);
        return head.value;//if the previous methods execute correctly, the head will be the return node

    }

    public void put(K key, V value)
    {
        if(hm.containsKey(key))
        {
            Node<K,V> temp = new Node<>(key, value);
            foundInCache(temp);
            System.out.println("Debug = put contains key");
        }
        else
        {
            System.out.println("Debug = put key not found");
            if (hm.size() >= capacity)
            {
                System.out.println("Debug = put key not found and cache is full");
                deleteTail();
            }

            setHead(new Node<>(key, value));
        }

    }

    private void deleteTail()
    {
        System.out.println("Debug = Deleting the tail");
        Node<K,V> ogTail = tail;
        tail = tail.prev;
        tail.next = null;
        hm.remove(ogTail.key);

    }

    private void foundInCache(Node<K,V> temp)
    {
        if(temp==tail)
        {
            System.out.println("Debug = foundInCache at the tail");
            tail = temp.prev;
            tail.next = null;
            setHead(temp);
        }
        else if(temp!=head)
        {
            try{

                System.out.println("Debug = foundInCache in middle : value:  " + temp.value);
                System.out.println("Debug = foundInCache in middle : prev:  " + temp.prev.value);
                System.out.println("Debug = foundInCache in middle : next : " + temp.next.value);

                Node<K,V> a = temp.prev;
                Node<K,V> b = temp.next;
                a.next = b;
                b.prev = a;

            }
            catch (NullPointerException e)
            {

            }
            setHead(temp);
        }

    }

    private void setHead(Node<K,V> temp)
    {
        if(hm.size()==0)
        {
            head = temp;
            tail = head;//for size 1 head and tail are same
            System.out.println("Debug = setHead empty cache");
        }
        else {
            temp.next = head;
            head.prev = temp;
            head = temp;
            System.out.println("Debug = setHead cache not empty");
        }
        hm.put(head.key, head);
        System.out.println(toString());
    }


    public String toString()
    {
        Node<K,V> temp = this.head;
        String retString  = "";
        while(temp.next!=null)
        {
            retString += temp.value+ " : ";
            temp = temp.next;
        }
        retString += temp.value+ " : ";
        return retString;
    }




}
