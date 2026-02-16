package linearbinarysearch;

/*
 * This class finds a peak element in an array using Binary Search.
 * A peak is an element greater than its immediate neighbors.
 * The algorithm runs in O(log n) time by eliminating half of the search space each step.
 * Returns the index of any one peak element.
 */

public class BinarySearchPeakElementUnique {

    // Returns the index of a peak element
    public static int findPeak(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2; // Safer than (left + right) / 2

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1; // Peak must exist on the right side
            } else {
                right = mid; // Peak is either mid or on the left side
            }
        }

        return left; // left == right points to a peak
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeak(nums);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);
    }
}

