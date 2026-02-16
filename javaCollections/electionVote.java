package collections;
/*
 * ElectionVoteTracker stores votes using HashMap, maintains voting order
 * with LinkedHashMap, and displays sorted results using TreeMap.
 */

import java.util.*;

public class ElectionVoteTracker {

    private Map<String, Integer> voteStore = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();

    // Casts a vote for a candidate
    public void castVote(String candidate) {

        voteStore.merge(candidate, 1, Integer::sum); // Increment votes
        voteOrder.put(candidate, voteStore.get(candidate)); // Maintain order
    }

    // Displays votes in insertion order
    public void displayVoteOrder() {
        voteOrder.forEach((k,v) -> System.out.println(k + " -> " + v));
    }

    // Displays sorted results
    public void displaySortedResults() {

        TreeMap<Integer, List<String>> sorted = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String,Integer> entry : voteStore.entrySet()) {

            sorted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey()); // Group candidates by vote count
        }

        sorted.forEach((votes, candidates) ->
                candidates.forEach(c -> System.out.println(c + " -> " + votes)));
    }

    // Entry point
    public static void main(String[] args) {

        ElectionVoteTracker tracker = new ElectionVoteTracker();

        tracker.castVote("Alice");
        tracker.castVote("Bob");
        tracker.castVote("Alice");
        tracker.castVote("Carol");
        tracker.castVote("Bob");
        tracker.castVote("Alice");

        System.out.println("Vote Order:");
        tracker.displayVoteOrder();

        System.out.println("\nSorted Results:");
        tracker.displaySortedResults();
    }
}
