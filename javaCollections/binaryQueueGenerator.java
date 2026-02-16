package collections;
/*
 * BinaryQueueGenerator produces the first N binary numbers
 * using a queue-based BFS approach.
 */

import java.util.*;

public class BinaryQueueGenerator {

    // Generates binary numbers up to N
    public static List<String> generateBinary(int n) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1"); // Start with binary 1

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            queue.add(current + "0"); // Append 0
            queue.add(current + "1"); // Append 1
        }

        return result;
    }

    // Entry point
    public static void main(String[] args) {

        System.out.println(generateBinary(5));
    }
}
