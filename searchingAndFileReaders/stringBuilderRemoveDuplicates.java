package linearbinarysearch;
/*
 * This class removes duplicate characters from a string while preserving the original order.
 * It uses a HashSet to track already seen characters and a StringBuilder to build the result.
 * Only the first occurrence of each character is kept.
 * Demonstrates efficient string manipulation with O(n) time complexity.
 */

import java.util.HashSet;

public class StringBuilderDuplicateRemover {

    // Removes duplicate characters while maintaining insertion order
    public static String removeDuplicates(String input) {
        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) { // Ensures each character is added only once
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String output = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + output);
    }
}
