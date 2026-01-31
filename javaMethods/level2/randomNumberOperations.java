
import java.util.*;
public class P12 {
    static int[] generate4DigitRandomArray(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) a[i] = (int)(Math.random() * 9000) + 1000;
        return a;
    }
    static double[] findAverageMinMax(int[] a) {
        int min = a[0], max = a[0], sum = 0;
        for (int x : a) {
            sum += x;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return new double[]{ (double)sum / a.length, min, max };
    }
    public static void main(String[] args) {
        int[] a = generate4DigitRandomArray(5);
        System.out.println(Arrays.toString(a));
        double[] r = findAverageMinMax(a);
        System.out.println("Average = " + r[0]);
        System.out.println("Min = " + r[1]);
        System.out.println("Max = " + r[2]);
    }
}
