package BinaryTreeMain;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


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

//#region All traversals in one

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

    Stack<ListItem> tra = new Stack<>();
    ListItem start = new ListItem(root, 1);
    tra.push(start);

    while(!tra.isEmpty())
    {
        ListItem temp = tra.pop();
        if(temp.val == 1)
        {
            pre.add(temp.key.value);
            temp.val++;
            tra.push(temp);

            if(temp.key.left != null)
            {
                tra.push(new ListItem(temp.key.left, 1));
            }
            
        }
        else if (temp.val == 2)
        {
            in.add(temp.key.value);
            temp.val++;
            tra.push(temp);
            if(temp.key.right != null)
            {  
            tra.push(new ListItem(temp.key.right, 1));
            }
        }
        else
        {
            pos.add(temp.key.value);
        }
    }




    for (int i : in)
    {
        System.out.print(i + " ");
        
    }
    System.out.println();
    for (int i : pre)
    {
        System.out.print(i + " ");
        
    }
    System.out.println();
    for (int i : pos) {
        System.out.print(i + " ");
        
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

//#region Lowest Common Ancestor

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
//#endregion

//#region Depth of tree

public void depth()
{
    Node temp = root;
    int height = 0;
    
    System.out.println(checkDepth(temp,height));
}

private int checkDepth(Node root, int height)
{
    if(root == null)
    {
        return 0;
    }
    int leftHeight = checkDepth(root.left, height);
    int rightHeight = checkDepth(root.right, height);
    return 1 + Math.max(leftHeight, rightHeight);
}

//#endregion

//#region is Balanced

public boolean isBalanced()
{
    Node temp = root;
    boolean ans = isBal(temp,0) == -1 ?  false : true;
    return ans;
}
private int isBal(Node root,int height)
{
    if(root == null)
    {
        return 0;
    }
    int leftHeight = isBal(root.left, height);
    if(leftHeight == -1) return -1;
    int rightHeight = isBal(root.right, height);
    if(rightHeight == -1) return -1;

    if(Math.abs(leftHeight-rightHeight)>=1)
    {
        return -1;
    }
    return 1 + Math.max(leftHeight, rightHeight);
}

//#endregion

//#region Diameter of a tree- [[dia means longest node chain not width of tree]]

public int Diameter()
{
    Node temp = root;
    int[] dia = new int[1];
    findDia(temp,dia);
    return dia[0];
}

private int findDia(Node root, int[] max)
{
    if(root == null)
    {
        return 0;
    }

    int leftDia = findDia(root.left,max);
    int rightDia = findDia(root.right,max);
    max[0] = Math.max(max[0],leftDia + rightDia);
    return Math.max(leftDia, rightDia)+1;
}

//#endregion

//#region Max Path Sum

public int maxSum()
{
    Node temp = root;
    int[]sum = new int[1];
    sum[0] = 0;
    maxPathSum(temp,sum);
    return sum[0];
}

private int maxPathSum(Node root, int[] sum) {
    if(root == null)
    {
        return 0;
    }
    int ls = maxPathSum(root.left, sum);
    int rs =  maxPathSum(root.right, sum);
    sum[0] = Math.max(ls + rs + root.value,sum[0]);
    return root.value + Math.max(ls, rs);
}

//#endregion

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
            bt.add(8);
            bt.add(9);

        
        bt.maxSum();
        
    }
}

