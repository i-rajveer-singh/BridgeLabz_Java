package collections;
/*
 * ListRotationManager rotates list elements by a given number
 * of positions without using Collections.rotate. It shifts elements
 * manually and reattaches the displaced portion.
 */

import java.util.*;

public class ListRotationManager {

    // Rotates list left by given positions
    public static <T> void rotate(List<T> list, int pos) {

        int n = list.size();
        pos = pos % n; // Avoid extra rotations

        List<T> temp = new ArrayList<>(list.subList(0, pos)); // Store first part

        for (int i = 0; i < n - pos; i++) {
            list.set(i, list.get(i + pos)); // Shift left
        }

        for (int i = 0; i < temp.size(); i++) {
            list.set(n - pos + i, temp.get(i)); // Attach stored elements
        }
    }

    // Entry point
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(10,20,30,40,50));

        rotate(nums, 2);

        System.out.println(nums);
    }
}
