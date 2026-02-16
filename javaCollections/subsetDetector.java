package collections;
/*
 * SubsetDetector checks whether one set is completely
 * contained within another using efficient Set operations.
 */

import java.util.*;

public class SubsetDetector {

    // Determines if set1 is subset of set2
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1); // True if all elements exist
    }

    // Entry point
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1,2,3,4));

        System.out.println(isSubset(set1, set2));
    }
}

