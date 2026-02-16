package linearbinarysearch;

/*
 * This class searches for a target value in a 2D sorted matrix using Binary Search.
 * The matrix is treated as a flattened 1D array to simplify the search logic.
 * Converts the mid index back to row and column during traversal.
 * Achieves O(log(rows * cols)) time complexity.
 */

public class BinarySearchMatrixFinderUnique {

    // Returns true if the target exists in the matrix
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Edge case: empty matrix
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2; // Prevents overflow

            int row = mid / cols; // Maps 1D index to row
            int col = mid % cols; // Maps 1D index to column

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (target < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        boolean found = searchMatrix(matrix, target);
        System.out.println("Target found: " + found);
    }
}

