
import java.util.*;
public class P11 {
    static double[] roots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta > 0) return new double[]{(-b + Math.sqrt(delta)) / (2 * a), (-b - Math.sqrt(delta)) / (2 * a)};
        else if (delta == 0) return new double[]{ -b / (2 * a) };
        else return new double[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        System.out.println(Arrays.toString(roots(a, b, c)));
    }
}
