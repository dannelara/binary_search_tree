import java.util.Iterator;

import utils.nodes.BSTNode;

public class Main {
    public static void main(String[] args) {
        Binary_search_tree bst = new Binary_search_tree();

        bst.add(4);
        bst.add(2);
        bst.add(6);
        bst.add(5);
        bst.add(9);
        bst.add(7);
        bst.add(11);

        Iterator<BSTNode> i = bst.postOrdIterator();

        while (i.hasNext())
            System.out.println(i.next().key);
    }
}
