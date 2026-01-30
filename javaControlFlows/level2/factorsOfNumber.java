import java.util.Scanner;

class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Factors of " + number + " are:");

        // Loop from 1 to number-1
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}
