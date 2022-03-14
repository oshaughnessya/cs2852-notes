package oshaughnessya.week2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Singly Linked List - can only travel forward
// Doubly Linked List - can travel forwards or backwards

// Each element is stored in a node, along with a pointer
// to the next node (and previous node if a doubly linked list)
public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    // private static class - "Inner class"
    // Objects are accessible from the "Outer class"
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> walker = head;

        while (walker != null) {
            size++;
            walker = walker.next;
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return null == head;
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
    public boolean add(E e) {
        if (isEmpty()) {
            head = new Node<>(e);
            tail = head;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E set(int index, Object element) {
        return null;
    }

    @Override
    public E remove(int index) {
        E removed = null;

        if (index == 0) {
            removed = head.value;
            head = head.next;

            if (head == null) {
                tail = null;
            }
        } else {
            Node<E> walker = head;
            while(index > 1) {
                index--;
                walker = walker.next;
            }

            removed = walker.next.value;
            walker.next = walker.next.next;
        }
        return removed;
    }

    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
