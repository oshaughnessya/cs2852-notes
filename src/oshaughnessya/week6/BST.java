package oshaughnessya.week6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class BST<E extends Comparable<? super E>> implements Set<E> {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.inOrder();
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node<E> subroot) {
        if (subroot != null) {
            inOrder(subroot.lKid);
            System.out.println(subroot.value);
            inOrder(subroot.rKid);
        }
    }

    private static class Node<E extends Comparable<? super E>> {
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

    private Node<E> root;

    public BST() {
        root = null;
    }

    @Override
    public int size() {
        return size(root);
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
        return root == null;
    }

    @Override
    public boolean contains(Object target) {
        return target instanceof Comparable<?> && contains(root, (E)target);
    }

    private boolean contains(Node<E> subroot, E target) {
        boolean found = false;
        if (subroot != null) {
            found = Objects.equals(target, subroot.value);
            if (!found) {
                if (subroot.value.compareTo(target) < 0) {
                    found = contains(subroot.rKid, target);
                } else {
                    found = contains(subroot.lKid, target);
                }
            }
        }
        return found;
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
    public boolean add(E element) {
        if(element == null) {
            throw new IllegalArgumentException("Nulls not allowed here.");
        }
        boolean changed = false;
        if (root == null) {
            root = new Node<>(element);
            changed = true;
        } else {
            changed = add(root, element);
        }
        return changed;
    }

    private boolean add(Node<E> subroot, E element) {
        boolean changed = false;
        if (!Objects.equals(subroot.value, element)) {
            if (subroot.value.compareTo(element) < 0) {
                if (subroot.rKid == null) {
                    subroot.rKid = new Node<>(element);
                    changed = true;
                } else {
                    changed = add(subroot.rKid, element);
                }
            } else {
                if (subroot.lKid == null) {
                    subroot.lKid = new Node<>(element);
                    changed = true;
                } else {
                    changed = add(subroot.lKid, element);
                }
            }
        }
        return changed;
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
        root = null;
    }

    public int height() {
        return isEmpty() ? -1 : height(root);
    }

    private int height(Node<E> subroot) {
        return subroot == null ? -1 : 1 + Math.max(height(subroot.lKid), height(subroot.rKid));
    }
}
