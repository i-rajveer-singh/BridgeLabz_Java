package collections;
/*
 * QueueReversalProcessor reverses a queue using only queue operations.
 * It recursively removes elements from the front and re-adds them
 * after the remaining queue is reversed.
 */

import java.util.*;

public class QueueReversalProcessor {

    // Recursively reverses the queue
    public static <T> void reverseQueue(Queue<T> queue) {
        if (queue.isEmpty()) return;

        T front = queue.remove(); // Remove front element
        reverseQueue(queue);
        queue.add(front); // Add it back after recursion
    }

    // Entry point
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10,20,30));

        reverseQueue(queue);

        System.out.println(queue);
    }
}
