
import java.util.Iterator;

import utils.lists.Queue;
import utils.nodes.BSTNode;

public class Binary_search_tree implements Iterable<BSTNode> {
    private BSTNode root;

    public Binary_search_tree() {
        root = null;
    }

    /** Public methods */

    /**
     * Method to get the root node;
     * 
     * @return BSTNode {root}
     */
    public BSTNode getRoot() {
        return root;
    }

    /**
     * Method to return the size of the tree;
     * 
     * @return int - size.
     */
    public int size() {
        return _size(root);

    }

    /**
     * Method returns the height of the tree;
     * 
     * @return - int.
     */
    public int height() {
        return _height(root);
    }

    /**
     * Method adds a node to the tree.
     */
    public void add(int i) {

        root = _add(root, i);
    }

    /**
     * Method removes a sspecific node from the tree.
     */
    public void remove(int i) {

        root = _delete(root, i);
    }

    /**
     * Method removes the kth largest node from the tree.
     */
    public void removeKth(int i) {

        root = _removeKth(root, i);
    }

    /**
     * Method returns true / false if node exists/doesnt exist in the tree.
     * 
     * @param i - int to find.
     * @return boolean.
     */
    public boolean contains(int i) {

        return _contains(root, i);
    }

    /** End of public methods */

    /* Private methods */

    private int _height(BSTNode n) {
        if (n == null)
            return -1;
        else
            return 1 + Math.max(_height(n.left), _height(n.right));
    }

    private BSTNode _add(BSTNode n, int i) {

        // If we reach the last node and it is null node doesn't exist and we return a
        // new Node.
        if (n == null)
            return new BSTNode(i, null, null);

        boolean equal = n.compare(i);

        // If they are equal node exists; Do nothing.
        if (equal)
            ;

        if (n.key > i)
            n.left = _add(n.left, i);

        if (n.key < i)
            n.right = _add(n.right, i);

        return n;
    }

    private BSTNode _removeKth(BSTNode root, int k) {

        if (k > 0) {
            // If the list is empty, the iterator throws an exception and we know that we
            // did not find any kth largest.
            InOrderReverseIterator it = new InOrderReverseIterator(k);

            // Just a place holder for the root to avoid null error. Root will never be
            // deleted since k will always be > 0 in this if statement.
            BSTNode nodeToDelete = root;

            // Add the next node to the nodeToDelete varaible until we reach the end of the
            // iterator.
            while (it.hasNext())
                nodeToDelete = it.next();

            return _delete(root, nodeToDelete.key);
        } else
            // If the kth == 0, we find the max node and delete it.
            return _delete(root, findMaxNode(root).key);

    }

    private BSTNode _delete(BSTNode n, int i) {
        if (n == null)
            return null;
        else if (n.key > i)
            n.left = _delete(n.left, i);

        else if (n.key < i)
            n.right = _delete(n.right, i);

        else {
            if (n.right == null)
                return n.left;

            if (n.left == null)
                return n.right;

            n.key = findMinNode(n.right).key;
            n.right = _delete(n.right, n.key);
        }
        return n;
    }

    private boolean _contains(BSTNode n, int i) {
        if (n == null)
            return false;

        if (n.key > i)
            return _contains(n.left, i);

        if (n.key < i)
            return _contains(n.right, i);

        return true;
    }

    private BSTNode findMaxNode(BSTNode n) {
        if (n != null) {
            while (n.right != null) {
                n = n.right;
            }
        }
        return n;
    }

    private BSTNode findMinNode(BSTNode n) {
        if (n == null)
            return null;
        else if (n.left == null)
            return n;

        return findMinNode(n.left);
    }

    private int _size(BSTNode n) {
        if (n == null)
            return 0;
        else
            return 1 + _size(n.left) + _size(n.right);
    }

    /** Iterators */
    @Override
    public Iterator<BSTNode> iterator() {

        return new InOrderIterator();
    }

    public Iterator<BSTNode> preOrderIterator() {

        return new PreOrderIterator();
    }

    public Iterator<BSTNode> postOrdIterator() {

        return new PostOrderIterator();
    }

    /** Iterator implementatios */
    private class InOrderIterator implements Iterator<BSTNode> {
        BSTNode current = root;
        Queue<BSTNode> stack;
        int stackSize = 0;

        public InOrderIterator() {
            stack = new Queue<>();
            storeNodes(root);
        }

        private void storeNodes(BSTNode n) {
            while (n != null) {
                stack.addLast(n);
                stackSize++;
                n = n.left;

            }

        }

        @Override
        public boolean hasNext() {
            return stackSize > 0;
        }

        @Override
        public BSTNode next() {

            current = stack.pop().data;

            stack.removeFirst();
            stackSize--;

            if (current.right != null) {
                storeNodes(current.right);
                return current;
            }

            return current;
        }

    }

    private class PreOrderIterator implements Iterator<BSTNode> {
        BSTNode current = root;
        Queue<BSTNode> stack;
        int stackSize = 0;

        public PreOrderIterator() {
            stack = new Queue<>();
            storeNodes(root);
        }

        private void storeNodes(BSTNode n) {
            if (n != null) {
                stack.addFirst(n);
                storeNodes(n.left);
                storeNodes(n.right);
                stackSize++;
            }

        }

        @Override
        public boolean hasNext() {
            return stackSize != 0;
        }

        @Override
        public BSTNode next() {

            current = stack.pop().data;

            stack.removeFirst();
            stackSize--;

            return current;
        }

    }

    private class PostOrderIterator implements Iterator<BSTNode> {
        BSTNode current = root;
        Queue<BSTNode> stack;
        int stackSize = 0;

        public PostOrderIterator() {
            stack = new Queue<>();
            storeNodes(root);
        }

        private void storeNodes(BSTNode n) {
            if (n != null) {

                storeNodes(n.left);
                storeNodes(n.right);
                stack.addFirst(n);
                stackSize++;
            }

        }

        @Override
        public boolean hasNext() {
            return stackSize != 0;
        }

        @Override
        public BSTNode next() {

            current = stack.pop().data;

            stack.removeFirst();
            stackSize--;

            return current;
        }

    }

    private class InOrderReverseIterator implements Iterator<BSTNode> {
        BSTNode current = root;
        Queue<BSTNode> stack;

        int kth;

        public InOrderReverseIterator(int k) {
            stack = new Queue<>();
            storeNodes(root);
            kth = k;
        }

        private void storeNodes(BSTNode n) {
            while (n != null) {
                stack.addLast(n);
                n = n.right;

            }

        }

        @Override
        public boolean hasNext() {
            return kth > 0;
        }

        @Override
        public BSTNode next() {

            if (stack.pop() == null) {
                throw new Error("Kth not found.");
            }

            current = stack.pop().data;

            stack.removeFirst();
            kth--;
            if (current.left != null) {
                storeNodes(current.left);
                return current;
            }

            return current;
        }

    }

}
