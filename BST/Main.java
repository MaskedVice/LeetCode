package BST;

class BST {

    class TreeNode {
    
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    
        public TreeNode(int val ,TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode root;

    BST(){ 
        root = null; 
    } 

    public boolean search(int x)
    {
        root = searchTree(root ,x);
        if(root == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    private TreeNode searchTree(TreeNode root,int x)
    {
        //if tree is null return null

        if(root == null) return null;
        
        // if value is at the head return head;
        if(root.val == x)
        {
            return root;
        }

        //if x is less than value of current node look in left sub-tree else search right sub tree
        if(x<root.val)
        {
            return (searchTree(root.left,x));
        }
        else
        {
            return (searchTree(root.right,x));
        }
    }

    public TreeNode findMin(TreeNode root)
    {
        TreeNode min;

        if(root == null) return null;

        min = root;
        while(min.left != null) min = min.left;

        return min;
    }

    public TreeNode findMax(TreeNode root)
    {
        TreeNode max;

        if(root == null) return null;

        max = root;
        while(max.left != null) max = max.left;

        return max;
    }

    public void traverse(){
        traverseTree(root);
    }
    
    private void traverseTree(TreeNode root)
    {
        if(root != null)
        {
            traverseTree(root.left);
            System.out.println(root.val);
            traverseTree(root.right);
        }
    }

    public void insert(int x)
    {
        root = insertNode(root, x);
    }
    private TreeNode insertNode(TreeNode root, int x)
    {
        TreeNode p;

        if(root == null){
            p = new TreeNode(x);
            p.left = p.right = null;
            root = p;
            return root;
        }

        if(x<root.val)
        {
            root.left = insertNode(root.left, x);
        }
        else
        {
            root.right = insertNode(root.right, x);
        }
        return root;
    }
    
}


public class Main {
    public static void main(String[] args) {
        BST b = new BST();
        for (int i : new int[]{50,70,60,20,90,10,40,100}) {
            b.insert(i);
        }
        b.traverse();
    }
}
