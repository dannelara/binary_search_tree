package utils.lists;

import java.util.Iterator;

import utils.nodes.Node;

public class Queue<Type> implements Iterable<Node<Type>> {
    private int size;
    private Node<Type> head = null;
    private Node<Type> last = null;

    public Node<Type> pop() {
        if (head != null) {
            return head;
        } else
            return null;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Type i) {

        if (head == null) {
            head = new Node<>(i, null);
            last = head;
        } else {
            last.next = new Node<>(i, null);
            last = last.next;
        }

        size++;
    }

    public void addLast(Type i) {

        if (head == null) {
            head = new Node<>(i, null);
        } else {
            Node<Type> node = new Node<>(i, null);
            node.next = head;

            head = node;
        }
        size++;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;

            if (head == null) {
                last = null;
            }
            size--;
        } else
            throw new Error("Can't remove from empty list");

    }

    public void removeLast() {

        if (head != null) {
            Node<Type> current = head;

            while (current.next.next != null) {
                current = current.next;
            }

            current.next = null;
            size--;
        } else
            throw new Error("Can't remove from empty list");

    }

    private void remove(Node<Type> n) {
        if (n != null) {
            head = n.next.next;
        }
    }

    @Override
    public Iterator<Node<Type>> iterator() {

        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Node<Type>> {
        private Node<Type> current = head;
        private Node<Type> prev = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node<Type> next() {
            prev = current;
            current = current.next;

            return prev;
        }

        public void remove() {
            Queue.this.remove(prev);
        }
    }

}
