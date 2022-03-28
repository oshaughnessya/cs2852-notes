package oshaughnessya.week4;

public interface PureStack<E> {
    // Always
    E pop();
    void push(E element);

    // Sometimes
    E peek();
    boolean isEmpty();

    // This is controversial
    int size();
}
