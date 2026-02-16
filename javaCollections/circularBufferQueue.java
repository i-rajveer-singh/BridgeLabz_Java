package collections;
/*
 * CircularBufferQueue simulates a fixed-size circular buffer.
 * When capacity is reached, the oldest element is overwritten.
 */

import java.util.*;

public class CircularBufferQueue<T> {

    private Object[] buffer;
    private int head = 0;
    private int size = 0;
    private int capacity;

    public CircularBufferQueue(int capacity) {
        this.capacity = capacity;
        buffer = new Object[capacity];
    }

    // Inserts element and overwrites oldest if full
    public void insert(T value) {
        int tail = (head + size) % capacity;

        buffer[tail] = value;

        if (size == capacity) {
            head = (head + 1) % capacity; // Move head forward
        } else {
            size++;
        }
    }

    // Returns buffer as list
    public List<T> getBuffer() {

        List<T> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add((T) buffer[(head + i) % capacity]); // Circular traversal
        }

        return list;
    }

    // Entry point
    public static void main(String[] args) {

        CircularBufferQueue<Integer> cb = new CircularBufferQueue<>(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);

        System.out.println(cb.getBuffer());
    }
}
