package week6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class BST<E extends Comparable<E>> implements Set<E> {

    private static class Node<E extends Comparable<E>> {
        E value;
        Node<E> rKid;
        Node<E> lKid;

        public Node(E value) {
            this(value, null, null);
        }

        public Node(E value, Node<E> rKid, Node<E> lKid) {
            this.value = value;
            this.rKid = rKid;
            this.lKid = lKid;
        }
    }

    private Node<E> head;

    public BST() {
        head = null;
    }

    @Override
    public int size() {
        return 0;
    }

    private int size(Node<E> subroot) {
        int size = 0;
        if(subroot != null) {
            size = 1 + size(subroot.lKid) + size(subroot.rKid);
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }
}
