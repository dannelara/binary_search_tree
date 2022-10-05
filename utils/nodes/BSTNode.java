package utils.nodes;

public class BSTNode {

    public int key;

    public BSTNode right;
    public BSTNode left;

    public BSTNode(int k, BSTNode r, BSTNode l) {
        key = k;
        right = r;
        left = l;
    }

    public boolean compare(int i) {
        return this.key == i;
    }
}
