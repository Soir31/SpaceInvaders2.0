package trees;

/**
 * Creates an AVL tree which will be used
 * for a new enemy type
 */
public class AvlMonsterTree {
    public AvlNode t;
    private int size = 0;
    private int height(AvlNode t){
        return t == null ? - 1 : t.height;
    }

    /**
     * Add a node with a value to the tree following
     * the balancing rules of an AVL tree
     * @param x
     * @param t
     * @return
     */
    public AvlNode insert(int x, AvlNode t){
        if (t == null){
            return new AvlNode(x);
        }
        if (x < t.element){
            t.left = insert(x, t.left);
        }else if (x > t.element){
            t.right = insert(x, t.right);
        }else{
            return t;
        }
        t.height = 1 + Math.max(height(t.left), height(t.right));
        int balance = getBalance(t);

        if (balance > 1 && x < t.left.element){
            return rotateWithRightChild(t);
        }
        if (balance < -1 && x > t.right.element){
            return rotateWithLeftChild(t);
        }
        if (balance > 1 && x > t.left.element){
            t.left = rotateWithLeftChild(t.left);
            return rotateWithRightChild(t);
        }
        if (balance < -1 && x < t.right.element){
            t.right = rotateWithRightChild(t.right);
            return rotateWithLeftChild(t);
        }
        return t;
    }
    /**
     * Rotates with the left children
     * when it is necessary
     * @param x
     * @return
     */
    private AvlNode rotateWithLeftChild(AvlNode x){
        AvlNode y = x.right;
        AvlNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    /**
     * Makes the rotation of the left children
     * @param k3
     * @return
     */
    private AvlNode doubleWithLeftChild(AvlNode k3){
        k3.left = rotateWithLeftChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Rotates with the right children
     * when it is necessary
     * @param y
     * @return
     */
    private AvlNode rotateWithRightChild(AvlNode y){
        AvlNode x = y.left;
        AvlNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }
    /**
     * Gets the minimum value of the tree
     * @param node
     * @return
     */
    private AvlNode minValueNode(AvlNode node){
        AvlNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    /**
     * Returns the balance of the tree nodes
     * @param t
     * @return
     */
    public int getBalance(AvlNode t){
        if (t == null)
            return 0;
        return height(t.left) - height(t.right);
    }

    /**
     * Deletes a node from the tree
     * following the balancing rules
     * @param t
     * @param x
     * @return
     */
    public AvlNode deletion(AvlNode t, int x){
        if (t == null)
            return t;
        if (x < t.element) {
            t.left = deletion(t.right, x);
        }
        else if (x > t.element) {
            t.right = deletion(t.right, x);
        }
        else {
            if ((t.left == null) || (t.right == null)){
                AvlNode temp = null;
                if (temp == t.left)
                    temp = t.right;
                else
                    temp = t.left;
                if (temp == null){
                    temp = t;
                    t = null;
                }
                else
                    t = temp;
            }else {
                AvlNode temp = minValueNode(t.right);
                t.element = temp.element;
                t.right = deletion(t.right, temp.element);
            }
        }
        if (t == null)
            return t;
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        int balance = getBalance(t);

        if (balance > 1 && getBalance(t.left) >= 0)
            return rotateWithRightChild(t);

        if (balance > 1 && getBalance(t.left) < 0){
            t.left = rotateWithLeftChild(t.left);
            return rotateWithRightChild(t);
        }
        if (balance < -1 && getBalance(t.right) <= 0)
            return rotateWithLeftChild(t);

        if (balance < -1 && getBalance(t.right) > 0){
            t.right = rotateWithRightChild(t.right);
            return rotateWithLeftChild(t);
        }
        return t;
    }

    /**
     * Finds a specific node of the tree
     * @param x
     * @return
     */
    public AvlNode getNode(int x){
        AvlNode current = t;
        while (current != null){
            if (current.element == x){
                break;
            }
            current = current.element < x ? current.right : current.left;
        }
        return current;
    }

    /**
     * Counts the total amount of elements
     * in the tree
     * @param t
     * @return
     */
    public int size(AvlNode t){
        if (t == null){
            return 0;
        }else {
            return 1 + size(t.left) + size(t.right);
        }
    }

    /**
     * Prints the actual elements of the tree in the
     * order that they were added or deleted
     * @param t
     */
    public void preOrder(AvlNode t){
        if (t != null){
            System.out.printf("%s ", t.element);
            preOrder(t.left);
            preOrder(t.right);
        }
    }
}
