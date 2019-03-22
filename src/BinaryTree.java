public class BinaryTree<E>
{
    private Association<E,E> node;
    protected E val; // value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node

    public BinaryTree()
// post: constructor that generates an empty node
    {
        val = null;
        parent = null; left = right = this;
    }
    public BinaryTree(E value)
// post: returns a tree referencing value and two empty subtrees
    {
        val = value;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }

    public boolean isEmpty(){
        if(parent == null) return true;
        else return false;
    }
    public BinaryTree( E key, E value)
// post: returns a tree referencing value and two subtrees
    {
        this.node = new Association<E, E>(key, value);
    }
    protected void setParent(BinaryTree<E> newParent)
// post: re-parents this node to parent reference, or null
    {
        if (!isEmpty()) {
            parent = newParent;
        }
    }
    public void setLeft(BinaryTree<E> newLeft)
// post: sets left subtree to newLeft
// re-parents newLeft if not null
    {
        if (isEmpty()) return;
        if (left != null /**&& /**left.parent() == this**/) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }
    public void setRight(BinaryTree<E> newRight)
// post: sets left subtree to newRight
// re-parents newRight if not null
    {
        if (isEmpty()) return;
        if (right != null /**&& right.parent() == this **/) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    public BinaryTree<E> left()
// post: returns reference to (possibly empty) left subtree
    {
        return left;
    }
    public E value()
// post: returns value associated with this node
    {
        return val;
    }
    public void setValue(E value)
// post: sets the value associated with this node
    {
        val = value;
    }

}