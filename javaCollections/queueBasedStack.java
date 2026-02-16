package collections;
/*
 * QueueBackedStack implements LIFO behavior using two queues.
 * Push rearranges elements so the newest item always stays at the front.
 */

import java.util.*;

public class QueueBackedStack<T> {

    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();

    // Pushes element onto stack
    public void push(T value) {
        q2.add(value);

        while (!q1.isEmpty()) {
            q2.add(q1.remove()); // Move older elements behind new one
        }

        Queue<T> temp = q1; // Swap queues
        q1 = q2;
        q2 = temp;
    }

    // Removes top element
    public T pop() {
        return q1.isEmpty() ? null : q1.remove();
    }

    // Returns top element
    public T top() {
        return q1.peek();
    }

    // Entry point
    public static void main(String[] args) {

        QueueBackedStack<Integer> stack = new QueueBackedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
    }
}
