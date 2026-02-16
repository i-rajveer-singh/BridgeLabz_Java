package linearbinarysearch;

/*
 * This class performs a Linear Search to find the first negative number in an array.
 * It scans the array from left to right and returns the index once found.
 * If no negative value exists, it returns -1.
 * Demonstrates the simplest searching technique with O(n) time complexity.
 */

public class LinearSearchFirstNegativeUnique {

    // Returns the index of the first negative number, or -1 if none exists
    public static int findFirstNegative(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) { // Negative numbers are always less than zero
                return i;
            }
        }

        return -1; // Indicates no negative number was found
    }

    public static void main(String[] args) {

        int[] numbers = {10, 25, 7, -3, 14, -8};

        int result = findFirstNegative(numbers);

        if (result != -1) {
            System.out.println("First negative number found at index: " + result);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}

