import java.util.Scanner;

class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int originalNumber = number;
        int sum = 0;

        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }

        if (originalNumber % sum == 0) {
            System.out.println("Harshad Number");
        } else {
            System.out.println("Not a Harshad Number");
        }
        sc.close();
    }
}
