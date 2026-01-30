import java.util.Scanner;

class P12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Multiples of " + number + " below 100:");

        // Loop backward from 100 to 1
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }

        sc.close();
    }
    
}
