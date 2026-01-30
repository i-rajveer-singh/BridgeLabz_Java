import java.util.Scanner;

public class P7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter weight (in kg): ");
        double weight = sc.nextDouble();

        System.out.print("Enter height (in cm): ");
        double heightCm = sc.nextDouble();

        
        double heightMeter = heightCm / 100;

        
        double bmi = weight / (heightMeter * heightMeter);

        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal weight";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        
        System.out.println("\nBMI = " + bmi);
        System.out.println("Weight Status: " + status);

        sc.close();
    }
}
