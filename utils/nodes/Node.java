package utils.nodes;

/*
 * Single linked node.
 */
public class Node<Type> {
    public Type data;
    public Node<Type> next;

    public Node(Type i, Node<Type> n) {
        data = i;
        next = n;
    }

}
