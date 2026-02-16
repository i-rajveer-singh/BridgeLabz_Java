package linearbinarysearch;
/*
 * This class finds the first and last occurrence of a target element
 * in a sorted array using Binary Search.
 * It performs two modified binary searches to locate boundary positions.
 * Ensures O(log n) time complexity instead of scanning the entire array.
 */

public class BinarySearchFirstLastOccurrenceUnique {

    // Finds the first occurrence of the target
    public static int findFirst(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        int result = -1; // Stores index if found

        while (left <= right) {

            int mid = left + (right - left) / 2; // Avoids overflow

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left side
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Finds the last occurrence of the target
    public static int findLast(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right side
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {2, 4, 4, 4, 6, 8, 9};
        int target = 4;

        int firstIndex = findFirst(nums, target);
        int lastIndex = findLast(nums, target);

        if (firstIndex == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First Occurrence Index: " + firstIndex);
            System.out.println("Last Occurrence Index: " + lastIndex);
        }
    }
}
