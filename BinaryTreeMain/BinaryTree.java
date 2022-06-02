package BinaryTreeMain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class BinaryTree 
{

    Node root;

    // ...

    public void add(int value) 
    {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) 
    {
        if (current == null) {
            return new Node(value);
        }
    
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
    
        return current;
    }

//#regionIn Order Traversal

    public void inOrderTraversal()
    {
        Node temp = root;
       iOT(temp);
    }
    private void iOT(Node root) {
        if(root != null)
        {
            iOT(root.left);
            System.out.print(root.value +  " ");
            iOT(root.right);
        }
    }


//#endregion

//#region Pre Order Traversal

    public void preOrderTraversal()
    {
        Node temp = root;
       pOT(temp);
    }
    private void pOT(Node root) {
        if(root != null)
        {
            System.out.print(root.value +  " ");
            pOT(root.left);
            pOT(root.right);
        }
    }

//#endregion

//#region Post Order Traversal

    public void postOrderTraversal()
    {
        Node temp = root;
       poOT(temp);
    }
    private void poOT(Node root) {
        if(root != null)
        {
            poOT(root.left);
            poOT(root.right);
            System.out.print(root.value + " ");
        }
    }

//#endregion
    
//#region Level Order Traversal

public ArrayList<Integer> levelOrderTraversal()
{
    Node temp = root;
    ArrayList<Integer> result = lot(temp);
    return result;
}
private ArrayList<Integer> lot(Node root) {
    Queue<Node> nodes = new LinkedList<>();
    ArrayList<Integer> res = new ArrayList<Integer>();

    nodes.add(root);
    while(!nodes.isEmpty())
    {
        Node cur = nodes.remove();
        if(cur.left != null)
        {
            nodes.add(cur.left);
        }
        if(cur.right != null)
        {
            nodes.add(cur.right);
        }
        res.add(cur.value);
    }

    return res;
}

//#endregion

//#region Lowest Common Ancestor

////#region All traversals in one

public void traversal()
{
    Node temp = root;
    travel(temp);
}
private void travel(Node root)
{
    ArrayList<Integer> in = new ArrayList<>();
    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> pos = new ArrayList<>();

    Queue<ListItem> tra = new LinkedList<>();
    ListItem start = new ListItem(root, 1);
    tra.add(start);

    while(!tra.isEmpty())
    {
        ListItem temp = tra.remove();
        if(temp.val == 1)
        {
            pre.add(temp.key.value++);
            tra.add(new ListItem(temp.key.left, 1));
            tra.add(new ListItem(temp.key.right, 1));
            tra.add(temp);
        }
        else if (temp.val == 2)
        {

        }
        else if (temp.val == 3)
        {
            
        }
    }

} 
class ListItem
{
    Node key;
    int val;
    public ListItem(Node a, int b)
    {
        this.key = a;
        this.val = b;
    }
}

//#endregion

public int lowestCommonAncestor(int a, int b)


    {
        Node one = new Node(a);
        Node two = new Node(b);
        Node temp = root;
        Node result = lca(temp, one , two);

        return result.value;
    }
    private Node lca(Node temp, Node one, Node two) 
    {
        if(temp == null || temp.value == one.value || temp.value == two.value)
        {
            return temp;
        }

        Node left = lca(temp.left,one,two);
        Node right = lca(temp.right,one,two);

        if(left == null)
        {
            return right;
        }
        else if(right == null)
        {
            return left;
        }
        else
        {
            return temp;
        }
    }


    public static void main(String[] args) 
    {
        
            BinaryTree bt = new BinaryTree();
            bt.add(5);
            bt.add(6);
            bt.add(2);
            bt.add(1);
            bt.add(3);
            bt.add(7);
            bt.add(4);

        
        //bt.inOrderTraversal();
        //System.out.println();
        //bt.preOrderTraversal();
        //System.out.println();
        //bt.postOrderTraversal();
        // 
        bt.traversal();
    }
}

