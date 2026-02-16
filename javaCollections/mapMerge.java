package collections;
/*
 * MapMergeAggregator merges two maps and sums values
 * when duplicate keys are encountered.
 */

import java.util.*;

public class MapMergeAggregator {

    // Merges maps with value summation
    public static Map<String, Integer> merge(Map<String, Integer> m1,
                                             Map<String, Integer> m2) {

        Map<String, Integer> result = new HashMap<>(m1);

        for (Map.Entry<String, Integer> entry : m2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum); // Sum duplicates
        }

        return result;
    }

    // Entry point
    public static void main(String[] args) {

        Map<String, Integer> map1 = Map.of("A",1,"B",2);
        Map<String, Integer> map2 = Map.of("B",3,"C",4);

        System.out.println(merge(map1, map2));
    }
}
