package collections;
/*
 * LinkedListNthFinder retrieves the Nth element from the end
 * without calculating the size by using a two-pointer technique.
 */

import java.util.*;

public class LinkedListNthFinder {

    // Finds Nth node from end safely
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {

        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) return null; // Handles invalid N
            fast.next();
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    // Entry point
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList("A","B","C","D","E"));

        System.out.println(findNthFromEnd(list, 2));
    }
}
