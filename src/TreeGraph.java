import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by bharatbatra on 1/2/16.
 */
public class TreeGraph
{


    public static void main(String args[]){

        PseudoNode[] nodes = new PseudoNode[20];
        Queue<PseudoNode> nq = new LinkedList<>();
        for(int i=0; i<13; i++)
        {
            nodes[i] = new PseudoNode(i);
            nq.add(nodes[i]);
        }

        System.out.println("Added Nodes to Q");
        System.out.println( nq.toString());

        nq.remove();
        for(int i=0; i<13; i++)
        {
            if(!nq.isEmpty())
                nodes[i].left = nq.remove();
            if(!nq.isEmpty())
                nodes[i].right = nq.remove();
        }

        nodes[13] = new PseudoNode(13);
        nodes[14] = new PseudoNode(14);
        nodes[15] = new PseudoNode(15);
        nodes[16] = new PseudoNode(16);

        nodes[11].left = nodes[13];
        nodes[11].right = nodes[14];

        nodes[13].left = nodes[15];
        nodes[13].right = nodes[16];

        levels(nodes[0]);
        System.out.println();
        levelsZigZag(nodes[0]);


    }

    public static void preOrder(PseudoNode root)
    {
        if(root!=null)
            root.visit();
        if(root.left!=null)
            preOrder(root.left);
        if(root.right!=null)
            preOrder(root.right);
    }

    public static void inOrder(PseudoNode root)
    {
//        if(root.left==null)
//            root.visit();
        if(root.left!=null)
            inOrder(root.left);

        root.visit();

        if(root.right!=null)
            inOrder(root.right);
    }

    public static void postOrder(PseudoNode root)
    {
//        if(root.left==null)
//            root.visit();
        if(root.left!=null)
            postOrder(root.left);



        if(root.right!=null)
            postOrder(root.right);

        root.visit();
    }

    public static void levels(PseudoNode root)
    {
        Queue<PseudoNode> bq = new LinkedList<>();
        bq.add(root);
        int i = 0;
        int levelSize = 0;
        int nextLine = 1;
        while(!bq.isEmpty()) {

            if (i == nextLine) {
                System.out.println();
                nextLine = i + levelSize;
                levelSize = 0;
            }
            PseudoNode temp = bq.remove();
            temp.visit();
            PseudoNode tLeft = temp.left;
            PseudoNode tRight = temp.right;
            if (tLeft != null) {
                bq.add(tLeft);
                levelSize++;

            }
            if (tRight != null) {
                bq.add(tRight);
                levelSize++;
            }
            i++;

        }
    }

    public static void levelsZigZag(PseudoNode root)
    {
        Queue<PseudoNode> bq = new LinkedList<>();
        bq.add(root);
        int i = 0;
        int levelSize = 0;
        int nextLine = 1;
        boolean l2r = true;
        while(!bq.isEmpty()) {

            if (i == nextLine) {
                System.out.println();
                nextLine = i + levelSize;
                levelSize = 0;
                l2r = !l2r;
                bq = stackFromQ(bq);

            }
            PseudoNode temp = bq.remove();
            temp.visit();
            PseudoNode tLeft = temp.left;
            PseudoNode tRight = temp.right;

            if(l2r)
            {
                if (tLeft != null)
                {
                    bq.add(tLeft);
                    levelSize++;
                }
                if (tRight != null)
                {
                    bq.add(tRight);
                    levelSize++;
                }
            }
            else
            {
                if (tRight != null)
                {
                    bq.add(tRight);
                    levelSize++;
                }
                if (tLeft != null)
                {
                    bq.add(tLeft);
                    levelSize++;
                }
            }
            i++;

        }


    }

    private static Queue<PseudoNode> stackFromQ(Queue<PseudoNode> ogQ)
    {
        Queue<PseudoNode> temp1 = new LinkedList<PseudoNode>();
        Queue<PseudoNode> temp2 = new LinkedList<PseudoNode>();
        while(!ogQ.isEmpty())
        {
            PseudoNode curr = ogQ.remove();

            if (temp1.isEmpty())
            {
                temp1.add(curr);
                while(!temp2.isEmpty())
                {
                    temp1.add(temp2.remove());
                }
            }
            else if(temp2.isEmpty())
            {
                temp2.add(curr);
                while(!temp1.isEmpty())
                {
                    temp2.add(temp1.remove());
                }
            }
        }
        if(!temp1.isEmpty())
            return  temp1;
        else
            return temp2;
    }



    


}

 class BTree {

    PseudoNode root;

    public BTree(PseudoNode root) {
        this.root = root;
    }
}

 class PseudoNode{
    PseudoNode left;
    PseudoNode right;
    int data;
    public boolean visited;

    public PseudoNode(int data)
    {
        this.data = data;
        this.left = null;
        this.right=null;
        this.visited = false;
        System.out.println("Constr " + data);

    }

    public PseudoNode(PseudoNode left, PseudoNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public PseudoNode(PseudoNode left, PseudoNode right) {
        this.left = left;
        this.right = right;
    }

    public void visit()
    {
        System.out.print(this.data + " ");
        visited = true;
    }
}
