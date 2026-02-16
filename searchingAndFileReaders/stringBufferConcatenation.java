package linearbinarysearch;

/*
 * This class demonstrates efficient concatenation of multiple strings using StringBuffer.
 * StringBuffer is mutable and thread-safe, making it suitable for multi-threaded environments.
 * It avoids creating multiple intermediate String objects during concatenation.
 * Shows how to build a single string from an array efficiently.
 */

public class StringBufferConcatenatorUnique {

    // Concatenates all strings from the array using StringBuffer
    public static String concatenateStrings(String[] arr) {
        StringBuffer buffer = new StringBuffer(); // Thread-safe mutable sequence of characters

        for (String str : arr) {
            buffer.append(str); // Appending avoids unnecessary object creation
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Java", " ", "is", " ", "fast", " ", "and", " ", "reliable"};
        String result = concatenateStrings(words);
        System.out.println("Concatenated String: " + result);
    }
}

