package collections;
/*
 * OrderedDuplicateRemover eliminates duplicate elements from a list
 * while maintaining the original insertion order using LinkedHashSet.
 */

import java.util.*;

public class OrderedDuplicateRemover {

    // Removes duplicates but preserves order
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> set = new LinkedHashSet<>(list); // Maintains order
        return new ArrayList<>(set);
    }

    // Entry point
    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(3,1,2,2,3,4);

        System.out.println(removeDuplicates(input));
    }
}
