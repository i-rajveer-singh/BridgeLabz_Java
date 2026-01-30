import java.util.Scanner;

public class P10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        // Result initialization
        int result = 1;

        // Loop to calculate power
        for (int i = 1; i <= power; i++) {
            result = result * number;
        }

        // Output
        System.out.println(number + " raised to the power " + power + " is: " + result);

        sc.close();
    }
}
