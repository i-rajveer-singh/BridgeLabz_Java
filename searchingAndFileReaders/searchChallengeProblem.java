package linearbinarysearch;
/*
 * This class demonstrates both Linear Search and Binary Search techniques.
 * Linear Search is used to find the first missing positive integer.
 * Binary Search is applied after sorting the array to locate a target element.
 * Combines two fundamental searching strategies in one practical example.
 */

import java.util.Arrays;

public class LinearBinarySearchChallengeUnique {

    // Finds the first missing positive integer using marking technique
    public static int firstMissingPositive(int[] arr) {

        int n = arr.length;

        // Replace non-positive numbers and numbers > n with a placeholder (n+1)
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        // Mark visited numbers by making the value at that index negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);

            if (num <= n && arr[num - 1] > 0) { // "-1" because index starts at 0
                arr[num - 1] = -arr[num - 1];
            }
        }

        // First positive index + 1 is the missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1; // If all numbers 1..n are present
    }

    // Performs Binary Search on a sorted array
    public static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2; // Prevents overflow

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {

        int[] numbers = {3, 4, -1, 1};

        int missing = firstMissingPositive(numbers.clone()); // Clone to preserve original array
        System.out.println("First Missing Positive: " + missing);

        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers); // Binary Search requires sorted data

        int target = 4;
        int index = binarySearch(sortedNumbers, target);

        System.out.println("Sorted Array: " + Arrays.toString(sortedNumbers));
        System.out.println("Target Index: " + index);
    }
}
