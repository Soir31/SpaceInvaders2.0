package trees;

/**
 * Class that creates the node for the
 * AVL tree
 */
public class AvlNode {
    int element;
    AvlNode right;
    AvlNode left;
    int height;

    /**
     * Constructor of the node
     * @param element
     */
    public AvlNode(int element){
        this(element, null, null);
    }
    public AvlNode(int element, AvlNode left, AvlNode right){
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}
