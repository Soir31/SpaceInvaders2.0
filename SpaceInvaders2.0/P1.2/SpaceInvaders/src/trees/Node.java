package trees;

/**
 *Class that creates a simple node that will
 * be used for the Binary Search tree
 */
public class Node{
    public int element;
    public Node left;
    public Node right;

    /**
     * Constructor of the node
     * @param element
     */
    public Node(int element){
        this(element, null, null);
    }

    public Node(int element, Node left, Node right){
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
