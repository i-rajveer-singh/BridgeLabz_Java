package collections;
/*
 * ElementFrequencyTracker counts occurrences of strings in a list
 * and stores the result inside a HashMap for fast lookup.
 */

import java.util.*;

public class ElementFrequencyTracker {

    // Builds frequency map safely
    public static Map<String, Integer> frequency(List<String> items) {
        Map<String, Integer> map = new HashMap<>();

        for (String item : items) {
            map.put(item, map.getOrDefault(item, 0) + 1); // Increment count
        }

        return map;
    }

    // Entry point
    public static void main(String[] args) {

        List<String> input = Arrays.asList("apple","banana","apple","orange");

        System.out.println(frequency(input));
    }
}
