import java.util.Scanner;

public class P8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input ages
        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();

        // Input heights
        System.out.print("Enter Amar's height (in cm): ");
        double amarHeight = sc.nextDouble();

        System.out.print("Enter Akbar's height (in cm): ");
        double akbarHeight = sc.nextDouble();

        System.out.print("Enter Anthony's height (in cm): ");
        double anthonyHeight = sc.nextDouble();

        // Find youngest
        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("Amar is the youngest friend");
        } else if (akbarAge < amarAge && akbarAge < anthonyAge) {
            System.out.println("Akbar is the youngest friend");
        } else {
            System.out.println("Anthony is the youngest friend");
        }

        // Find tallest
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Amar is the tallest friend");
        } else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            System.out.println("Akbar is the tallest friend");
        } else {
            System.out.println("Anthony is the tallest friend");
        }

        sc.close();
    }
}
