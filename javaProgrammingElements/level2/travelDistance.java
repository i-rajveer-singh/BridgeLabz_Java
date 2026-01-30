package level2;

import java.util.Scanner;

class TravelComputation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Person Name
        System.out.print("Enter traveller name: ");
        String name = sc.nextLine();

        // Cities
        System.out.print("Enter From City: ");
        String fromCity = sc.nextLine();

        System.out.print("Enter Via City: ");
        String viaCity = sc.nextLine();

        System.out.print("Enter To City: ");
        String toCity = sc.nextLine();

        // Distances
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " (in km): ");
        double distanceFromToVia = sc.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + " (in km): ");
        double distanceViaToFinalCity = sc.nextDouble();

        // Time input
        System.out.print("Enter hours taken from " + fromCity + " to " + viaCity + ": ");
        int hours1 = sc.nextInt();

        System.out.print("Enter minutes taken from " + fromCity + " to " + viaCity + ": ");
        int minutes1 = sc.nextInt();

        int timeFromToVia = hours1 * 60 + minutes1;

        System.out.print("Enter hours taken from " + viaCity + " to " + toCity + ": ");
        int hours2 = sc.nextInt();

        System.out.print("Enter minutes taken from " + viaCity + " to " + toCity + ": ");
        int minutes2 = sc.nextInt();

        int timeViaToFinalCity = hours2 * 60 + minutes2;

        // Total Distance and Time
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;

        // Convert total time back to hours & minutes
        int totalHours = totalTime / 60;
        int totalMinutes = totalTime % 60;

        // Output
        System.out.println("\nThe Total Distance travelled by " + name +
                " from " + fromCity + " to " + toCity + " via " + viaCity +
                " is " + totalDistance + " km and the Total Time taken is " +
                totalHours + " Hours " + totalMinutes + " Minutes");
    }
}