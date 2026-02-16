package collections;
/*
 * SymmetricSetAnalyzer finds elements that exist in either
 * of the two sets but not in both.
 */

import java.util.*;

public class SymmetricSetAnalyzer {

    // Computes symmetric difference
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {

        Set<T> result = new HashSet<>(set1);
        result.addAll(set2); // Union

        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        result.removeAll(intersection); // Remove common elements

        return result;
    }

    // Entry point
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));

        System.out.println(symmetricDifference(set1, set2));
    }
}
