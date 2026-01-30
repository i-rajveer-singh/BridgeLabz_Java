import java.util.Scanner;

public class Problem13{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n >= 0) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            int formulaSum = n * (n + 1) / 2;
            System.out.println("For Loop Sum: " + sum);
            System.out.println("Formula Sum: " + formulaSum);
        }
        sc.close();
    }
}
