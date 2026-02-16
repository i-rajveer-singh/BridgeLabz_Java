package linearbinarysearch;

/*
 * This class finds the rotation point (index of the smallest element)
 * in a rotated sorted array using Binary Search.
 * It reduces the search space by comparing the middle element with the rightmost element.
 * Provides O(log n) time complexity, making it efficient for large arrays.
 */

public class BinarySearchRotationPointUnique {

    // Returns the index of the smallest element (rotation point)
    public static int findRotationPoint(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2; // Prevents integer overflow

            if (arr[mid] > arr[right]) {
                left = mid + 1; // Rotation point must be in the right half
            } else {
                right = mid; // Could be mid itself, so don't skip it
            }
        }

        return left; // left == right is the index of the smallest element
    }

    public static void main(String[] args) {

        int[] nums = {15, 18, 2, 3, 6, 12};

        int rotationIndex = findRotationPoint(nums);

        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + nums[rotationIndex]);
    }
}

