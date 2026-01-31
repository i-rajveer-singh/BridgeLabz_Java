
import java.util.*;
public class P8 {
    static int youngest(int[] age) {
        return Math.min(age[0], Math.min(age[1], age[2]));
    }
    static int tallest(int[] h) {
        return Math.max(h[0], Math.max(h[1], h[2]));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[3];
        int[] height = new int[3];
        for (int i = 0; i < 3; i++) age[i] = sc.nextInt();
        for (int i = 0; i < 3; i++) height[i] = sc.nextInt();
        System.out.println("Youngest = " + youngest(age));
        System.out.println("Tallest = " + tallest(height));
    }
}
