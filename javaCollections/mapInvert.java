package collections;
/*
 * MapInverterUtility reverses key-value mapping while storing
 * duplicate values into lists to prevent data loss.
 */

import java.util.*;

public class MapInverterUtility {

    // Inverts a map with list handling for duplicate values
    public static <K, V> Map<V, List<K>> invert(Map<K, V> input) {

        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : input.entrySet()) {

            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey()); // Append key to list
        }

        return inverted;
    }

    // Entry point
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",1);

        System.out.println(invert(map));
    }
}
