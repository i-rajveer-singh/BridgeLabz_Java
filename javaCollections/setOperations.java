package collections;
/*
 * SetOperationsHub computes union and intersection of two sets
 * using standard Set operations while keeping originals unchanged.
 */

import java.util.*;

public class SetOperationsHub {

    // Returns union of two sets
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1); // Copy to avoid modifying original
        result.addAll(set2);
        return result;
    }

    // Returns intersection of two sets
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    // Entry point
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));

        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
    }
}
