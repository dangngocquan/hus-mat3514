package hw6_22001273_nguyenhoangminh.exercise5.airplanemanager;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        FlightManager manager = new FlightManager(20);
        Scanner sc = new Scanner(System.in);

        System.out.println("Pick an option (Enter the number only: ");
        System.out.println("1. Register journey.");
        System.out.println("2. Prepare for next departing flight.");
        System.out.println("3. Prepare for next arriving flight.");
        System.out.println("4. Exit programme.");

        int option = sc.nextInt();

        while(option != 4) {
            if (option == 1) {
                System.out.print("Flight name: ");
                String name = sc.next();

                System.out.print("Flight ID: ");
                int ID = sc.nextInt();

                Flight flight = new Flight(name, ID);

                System.out.print("Your departure (hour only): ");
                int dHour = sc.nextInt();
                System.out.print("Your departure (minute only): ");
                int dMinute = sc.nextInt();

                System.out.print("Your arrival (hour only): ");
                int aHour = sc.nextInt();
                System.out.print("Your arrival (minute only): ");
                int aMinute = sc.nextInt();

                manager.registerArrival(flight, aHour, aMinute);
                manager.registerDeparture(flight, dHour, dMinute);
                manager.display();
            } else if (option == 2) {
                System.out.println("Next departing: " + manager.nextDeparture());
                manager.removeDeparted();
                manager.display();
            } else if (option == 3) {
                System.out.println("Next arriving: " + manager.nextArrival());
                manager.removeArrived();
                manager.display();
            }

            System.out.print("Pick an option (Enter the number only:    ");
            System.out.print("1. Register journey.      ");
            System.out.print("2. Prepare for next departing flight.     ");
            System.out.print("3. Prepare for next arriving flight.       ");
            System.out.println("4. Exit programme.");

            option = sc.nextInt();
        }
    }
}
