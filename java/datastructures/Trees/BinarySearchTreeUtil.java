package datastructures.Trees;

public class BinarySearchTreeUtil {
    private BinarySearchTreeNode root;

    public BinarySearchTreeUtil() {
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int data){
        root = insert(root, data);
    }

    private BinarySearchTreeNode insert(BinarySearchTreeNode node, int data) {
        if (node == null)
            node = new BinarySearchTreeNode(data);
        else {
            if(data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right= insert(node.right, data);
        }
        return node;
    }

    public void delete(int k){
        if (isEmpty())
            System.out.println("Treee Empty");
        else if (search(k) == false)
            System.out.println(k + " is not present");
        else {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    private BinarySearchTreeNode delete(BinarySearchTreeNode root, int k){
        BinarySearchTreeNode p, p2, n;
        if (root.getData() == k) {
            BinarySearchTreeNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()){
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(BinarySearchTreeNode r, int val){
        boolean found = false;
        while ((r != null) && !found) {
                int rval = r.getData();
                if(val < rval)
                    r = r.getLeft();
                else if (val > rval)
                    r = r.getRight();
                else {
                    found = true;
                    break;
                }
                found = search(r, val);
        }
        return found;
    }

    public void printTree()
    {
        printTree(root);
    }

    private void printTree(BinarySearchTreeNode r)
    {
        if (r != null)
        {
            printTree(r.getLeft());
            System.out.println(r.getData() + " ");
            printTree(r.getRight());
        }
    }



}
