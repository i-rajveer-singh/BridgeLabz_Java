package collections;
/*
 * SortedSetTransformer converts an unsorted HashSet into
 * an ascending sorted list for ordered access.
 */

import java.util.*;

public class SortedSetTransformer {

    // Converts set to sorted list
    public static List<Integer> toSortedList(Set<Integer> set) {

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list); // Sort ascending

        return list;
    }

    // Entry point
    public static void main(String[] args) {

        Set<Integer> input = new HashSet<>(Arrays.asList(5,3,9,1));

        System.out.println(toSortedList(input));
    }
}
