package oshaughnessya.week4;

import java.util.NoSuchElementException;

public class CircularQueue<E> implements PureQueue<E> {
    private Object[] data;
    private int front;
    private int back;
    private boolean isEmpty;

    public static void main(String[] args) {
        PureQueue<String> names = new CircularQueue<>(5);
        names.enqueue("Aiden");
        names.enqueue("Benjamin");
        names.enqueue("Ayden");
        System.out.println(names.dequeue());
        names.enqueue("Benjamin");
        names.enqueue("Kali");
        names.enqueue("Matthew");
        while (!names.isEmpty()) {
            System.out.println(names.dequeue());
        }
    }

    public CircularQueue(int capacity) {
        data = new Object[capacity];
        front = 0;
        back = 0;
        isEmpty = true;
    }

    @Override
    public E dequeue() {
        if (isEmpty) {
            throw new NoSuchElementException("CircularQueue is empty");
        }
        E element = (E)data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (front == back) {
            isEmpty = true;
        }
        return element;
    }

    @Override
    public void enqueue(E element) {
        if (!isEmpty && front == back) {
            throw new IllegalStateException("At Capacity");
        }
        data[back] = element;
        back = (back + 1) % data.length;
        isEmpty = false;
    }

    @Override
    public E peek() {
        if (isEmpty) {
            throw new NoSuchElementException("CircularQueue is empty");
        }
        return (E)data[front];
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }
}
