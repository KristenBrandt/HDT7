import java.util.Stack;
// codigo tomado de https://www.sanfoundry.com/java-program-implement-binary-tree/
public class Node <E>{
    private BinaryTree root;

    public void insert(E data)
    {
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private BinaryTree insert(BinaryTree node, E data)
    {
        if (node == null)
            node = new BinaryTree(data);
        else
        {
            if (node.right == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BinaryTree r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.val +"\n");
            inorder(r.right);
        }
    }
    public Object getValue(BinaryTree r)
// post: returns value from association
    {
        return r.right;
    }
    public Object getKey(BinaryTree r)
// post: returns key from association
    {
        return r.left;
    }
}
