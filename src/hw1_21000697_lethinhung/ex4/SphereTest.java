package hw1_21000697_lethinhung.ex4;

import java.util.Scanner;

public class SphereTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("First Sphere");
        System.out.print("r = ");
        double r1 = sc.nextDouble();
        System.out.print("x = ");
        double x1 = sc.nextDouble();
        System.out.print("y = ");
        double y1 = sc.nextDouble();
        System.out.print("z = ");
        double z1 = sc.nextDouble();
        Sphere sphere1 = new Sphere(r1,x1,y1,z1);

        double area = sphere1.area();
        System.out.println("Area = " + area);
        double volume = sphere1.volume();
        System.out.println("Volume = " + volume);

        System.out.println("Second Sphere");
        System.out.print("r = ");
        double r2 = sc.nextDouble();
        System.out.print("x = ");
        double x2 = sc.nextDouble();
        System.out.print("y = ");
        double y2 = sc.nextDouble();
        System.out.print("z = ");
        double z2 = sc.nextDouble();
        Sphere sphere2 = new Sphere(r2,x2,y2,z2);

        if (sphere1.isCovered(sphere2)) {
            System.out.println("Hai hinh cau bao nhau");
        } else if (sphere1.isIntersecting(sphere2)) {
            System.out.println("Hai hinh cau giao nhau");
        } else {
            System.out.println("Hai hinh cau khong bao nhau va khong giao nhau");
        }

    }
}
