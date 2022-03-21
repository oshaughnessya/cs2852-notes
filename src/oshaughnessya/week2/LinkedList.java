package oshaughnessya.week2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

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
        tail = null;
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

    private class ArrayListIterator implements Iterator<E> {
        Node<E> next = head;
        Node<E> previous = null;
        Node<E> previousPrevious = null;

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            E value = next.value;
            previousPrevious = previous;
            previous = next;
            next = next.next;
            return value;
        }

        @Override
        public void remove() {
            if (previous == null) {
                throw new IllegalStateException("removed called twice in a row");
            }
            previousPrevious.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
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
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + " invalid for size " + size());
        }

        Node<E> walker = head;
        while (index > 0) {
            walker = walker.next;
            index--;
        }

        return walker.value;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + " invalid for size " + size());
        }

        if (index == 0) {
            head = new Node<>(element, head);
        } else {

        }
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + " invalid for size " + size());
        }

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

            // check if we removed the tail and change if needed
            if (walker.next == null) {
                tail = walker;
            }
        }
        return removed;
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        Node<E> walker = head;

        for (int i = 0; walker != null && index == -1; i++) {
            if (Objects.equals(walker.value, o)) {
                index = i;
            }
            walker = walker.next;
        }

        return index;
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
