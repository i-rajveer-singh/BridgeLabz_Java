package collections;
/*
 * MaxValueKeyFinder scans a map to locate the key associated
 * with the maximum integer value efficiently.
 */

import java.util.*;

public class MaxValueKeyFinder {

    // Returns key with highest value
    public static String findMaxKey(Map<String, Integer> map) {

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) { // Update max
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    // Entry point
    public static void main(String[] args) {

        Map<String, Integer> map = Map.of("A",10,"B",20,"C",15);

        System.out.println(findMaxKey(map));
    }
}
