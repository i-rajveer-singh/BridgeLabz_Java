import java.util.Scanner;

class NaturalSumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n >= 0) {
            int sum = 0, i = 1;
            while (i <= n) {
                sum += i;
                i++;
            }
            int formulaSum = n * (n + 1) / 2;
            System.out.println("While Loop Sum: " + sum);
            System.out.println("Formula Sum: " + formulaSum);
        }
        sc.close();
    }
}
