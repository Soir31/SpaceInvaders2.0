package trees;

/**
 * Creates a binary search tree to use for a new
 * enemy type
 */
public class BinaryMonsterTree{
    public Node root;
    private int size;

    public BinaryMonsterTree(){
        this.root = null;
        size = 0;
    }

    /**
     * Constructor of the add method
     * @param element
     */
    public void add(int element) {
        this.root = this.add(element, this.root);
    }

    /**
     * Inserts a node with a new value to the tree
     * @param element
     * @param current
     * @return
     */
    private Node add(int element, Node current){
        if (current == null) {
            return new Node(element, null, null);
        }

        if (element < current.element) {
            current.left = this.add(element, current.left);
        }
        else if (element > current.element) {
            current.right = this.add(element, current.right);
        }else {
            return current;
        }
        return current;
    }

    /**
     * Confirms that the tree is empty
     * @return
     */
    public boolean isEmpty(){
        return this.root == null;
    }

    /**
     * Search if a value is in the tree
     * @param element
     * @return
     */
    public boolean contains(int element){
        return this.contains(element, this.root);
    }

    private boolean contains(int element, Node node){
        if (node == null){
            return false;
        }else {
            if (element == node.element)
                return true;
        }
        return element < node.element
                ? contains(element, node.left)
                : contains(element, node.right);
    }
    /**
     * Returns the minimum element of the tree
     * @param node
     * @return
     */
    int findMin(Node node){
        int minv = node.element;
        while (node.left != null){
            minv = node.left.element;
            node = node.left;
        }
        return minv;
    }

    /**
     * Returns the maximum element of the tree
     * @param node
     * @return
     */
    private Node findMax(Node node){
        if (node != null)
            while (node.right != null){
                node = node.right;
            }
        return node;
    }

    /**
     * Constructor of the delete method
     * @param element
     */
    public void delete(int element){
        this.root = this.delete(element, this.root);
    }

    /**
     * Deletes a node and value of a tree
     * @param element
     * @param node
     * @return
     */
    public Node delete(int element, Node node) {
        if (node == null) {
            return node;
        }
        if (element > node.element) {
            node.right = delete(element, node.right);
        } else if (element < node.element) {
            node.left = delete(element, node.left);
        } else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            node.element = findMin(node.right);
            node.right = delete(node.element, node.right);
        }
        return node;
    }

    /**
     * Gets the value of a node of the tree
     * @param key
     * @return
     */
    public Node gets(int key){
        Node current = root;
        while (current != null) {
            if (current.element == key) {
                break;
            }
            current = current.element < key ? current.right : current.left;
        }
        return current;
    }

    /**
     * Counts the total number of elements of a tree
     * @param root
     * @return
     */
    public int size(Node root){
        if (root == null){
            return 0;
        }else {
            return 1 + size(root.left) + size(root.right);
        }
    }

    /**
     * Prints the elements of the node from the lowest value
     * to highest value
     * @param current
     */
    public void inOrder(Node current){
        if (current == null){
            return;
        }
        inOrder(current.left);
        System.out.printf("%s ", current.element);
        inOrder(current.right);
    }
}
