package hw1_21000245_nguyenthihaphuong.Exercise4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SphereCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of spheres you want to initialize: ");
            int numSpheres = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Sphere[] spheres = new Sphere[numSpheres];

            for (int i = 0; i < numSpheres; i++) {
                boolean validInput = false;
                do {
                    try {
                        System.out.println("Enter parameters of sphere number " + (i + 1) + ":");
                        System.out.print("Radius (r" + (i + 1) + "): ");
                        double r = scanner.nextDouble();
                        System.out.print("Center x-coordinate (x" + (i + 1) + "): ");
                        double x = scanner.nextDouble();
                        System.out.print("Center y-coordinate (y" + (i + 1) + "): ");
                        double y = scanner.nextDouble();
                        System.out.print("Center z-coordinate (z" + (i + 1) + "): ");
                        double z = scanner.nextDouble();
                        spheres[i] = new Sphere(r, x, y, z);
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter valid numeric values.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                } while (!validInput);
            }

            // Perform operations on spheres
            for (int i = 0; i < numSpheres; i++) {
                System.out.println("Sphere " + (i + 1) + " details: " + spheres[i]);
                System.out.println("Surface Area: " + spheres[i].calculateSurfaceArea());
                System.out.println("Volume: " + spheres[i].calculateVolume());
            }

            // Check if two spheres intersect
            boolean validIndices = false;
            int sphereIndex1 = 0;
            int sphereIndex2 = 0;
            do {
                try {
                    System.out.println("Enter the indices of two spheres to check for intersection (1 to " + numSpheres + "):");
                    sphereIndex1 = scanner.nextInt() - 1; // Adjust for 0-based indexing
                    sphereIndex2 = scanner.nextInt() - 1;
                    validIndices = (sphereIndex1 >= 0 && sphereIndex1 < numSpheres) && (sphereIndex2 >= 0 && sphereIndex2 < numSpheres);
                    if (!validIndices) {
                        System.out.println("Invalid sphere indices. Please enter valid indices.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter valid numeric values.");
                    scanner.nextLine(); // Consume the invalid input
                }
            } while (!validIndices);

            double distance = spheres[sphereIndex1].distanceTwoSphere(spheres[sphereIndex2]);
            System.out.println("Distance between Sphere " + (sphereIndex1 + 1) + " and Sphere " + (sphereIndex2 + 1) + ": " + distance);

            if (spheres[sphereIndex1].isIntersect(spheres[sphereIndex2])) {
                System.out.println("Sphere " + (sphereIndex1 + 1) + " and sphere " + (sphereIndex2 + 1) + " intersect.");
            } else {
                System.out.println("Sphere " + (sphereIndex1 + 1) + " and sphere " + (sphereIndex2 + 1) + " do not intersect.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid sphere index. Please enter valid indices.");
        }

        scanner.close();
    }
}
