package linearbinarysearch;
/*
 * This class demonstrates how to reverse a string using StringBuilder.
 * It appends the input string to a StringBuilder object and uses the built-in reverse() method.
 * The reversed result is then converted back to a String and displayed.
 * Useful for understanding mutable string operations in Java.
 */

public class StringBuilderReversalDemo {

    // Reverses the given string using StringBuilder's reverse() method
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input); // StringBuilder is mutable, so reversal is efficient
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }
}
