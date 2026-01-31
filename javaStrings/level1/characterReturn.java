import java.util.*;

class ques3 {

    // Method to return all characters using charAt()
    static char[] getCharsUsingCharAt(String s) {

        char[] arr = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        return arr;
    }

    // Method to compare two char arrays
    static boolean compareCharArrays(char[] a, char[] b) {

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter the string: ");
        String str = sc.next();

        // Using user-defined method
        char[] arr1 = getCharsUsingCharAt(str);

        // Using built-in method
        char[] arr2 = str.toCharArray();

        // Compare both arrays
        boolean result = compareCharArrays(arr1, arr2);

        // Display arrays and result
        System.out.println("Characters using charAt(): " + Arrays.toString(arr1));
        System.out.println("Characters using toCharArray(): " + Arrays.toString(arr2));
        System.out.println("Are both character arrays equal? " + result);
        sc.close();
    }
}
