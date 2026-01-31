
import java.util.*;
public class P9 {
    static boolean isPositive(int n) { return n >= 0; }
    static boolean isEven(int n) { return n % 2 == 0; }
    static int compare(int a, int b) {
        if (a > b) return 1;
        if (a == b) return 0;
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
            if (isPositive(a[i])) System.out.println(isEven(a[i]) ? "Even" : "Odd");
            else System.out.println("Negative");
        }
        System.out.println(compare(a[0], a[4]));
    }
}
