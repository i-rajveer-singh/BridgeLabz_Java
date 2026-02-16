package collections;
/*
 * ListReversalEngine reverses elements of both ArrayList and LinkedList
 * without using built-in reverse utilities. It uses a two-pointer
 * swapping approach to modify the list in-place efficiently.
 */

import java.util.*;

public class ListReversalEngine {

    // Reverses any list using manual swapping
    public static <T> void reverse(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left); // Swap elements
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // Entry point
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1,2,3,4,5));

        reverse(arrayList);
        reverse(linkedList);

        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
