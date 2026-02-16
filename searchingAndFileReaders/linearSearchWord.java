package linearbinarysearch;

/*
 * This class performs a Linear Search on an array of sentences
 * to find the first sentence that contains a specific word.
 * It returns the matching sentence or "Not Found" if no match exists.
 * Demonstrates practical string searching using a simple O(n) approach.
 */

public class LinearSearchSentenceFinderUnique {

    // Returns the first sentence containing the target word
    public static String findSentence(String[] sentences, String targetWord) {

        String normalizedTarget = targetWord.toLowerCase(); // Enables case-insensitive search

        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(normalizedTarget)) { // Checks substring presence
                return sentence;
            }
        }

        return "Not Found"; // Indicates the word was not present in any sentence
    }

    public static void main(String[] args) {

        String[] sentences = {
                "Java is a powerful language",
                "Data structures are important",
                "Linear search is easy to understand",
                "Practice makes perfect"
        };

        String word = "search";

        String result = findSentence(sentences, word);
        System.out.println("Result: " + result);
    }
}

