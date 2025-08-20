import java.util.*;

class Flat {
    String name;
    int rent;
    int distance; // km
    int time; // minutes
    int locationAdvantage;

    Flat(String name, int rent, int distance, int time, int locationAdvantage) {
        this.name = name;
        this.rent = rent;
        this.distance = distance;
        this.time = time;
        this.locationAdvantage = locationAdvantage;
    }

    int calculateCost() {
        int distanceCost = distance * 10 * 20; // Rs 10 per km × 20 days
        int timeCost = time * 5 * 20; // Rs 5 per min × 20 days
        return rent + distanceCost + timeCost - locationAdvantage;
    }
}

public class BestFlat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of flats: ");
        int n = sc.nextInt();
        Flat[] flats = new Flat[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for flat " + (i + 1) +
                    " (name rent distance time locationAdvantage ):");
            String name = sc.next();
            int rent = sc.nextInt();
            int distance = sc.nextInt();
            int time = sc.nextInt();
            int locationAdvantage = sc.nextInt();

            flats[i] = new Flat(name, rent, distance, time, locationAdvantage);
        }
        sc.close();

        Flat bestFlat = flats[0];
        int minCost = bestFlat.calculateCost();

        System.out.println("\n---- Monthly Cost Calculation ----");
        for (Flat f : flats) {
            int cost = f.calculateCost();
            System.out.println("------------------------------------------");
            System.out.println("Flat Name          : " + f.name);
            System.out.println("Rent               : Rs." + f.rent);
            System.out.println("Distance (km)      : " + f.distance);
            System.out.println("Travel Time (min)  : " + f.time);
            System.out.println("Location Advantage : Rs." + f.locationAdvantage);
            System.out.println("Total Monthly Cost : Rs." + cost);
            if (cost < minCost) {
                minCost = cost;
                bestFlat = f;
            }
        }
        System.out.println("----------------------------------");
        System.out.println("Most beneficial flat is: " + bestFlat.name +
                " with total monthly cost Rs." + minCost);
    }
}
