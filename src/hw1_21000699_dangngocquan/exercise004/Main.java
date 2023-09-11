package hw1_21000699_dangngocquan.exercise004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create and show spheres
        Sphere sphere01 = new Sphere(10, 0, 0, 0);
        Sphere sphere02 = new Sphere(5, 1, 2, 3);
        Sphere sphere03 = new Sphere(10, 11, 11, 11);
        Sphere sphere04 = new Sphere(10, 9, 9, 9);

        System.out.println("sphere01: " + sphere01);
        System.out.println("sphere02: " + sphere02);
        System.out.println("sphere03: " + sphere03);
        System.out.println("sphere04: " + sphere04);

        // sphere01: Sphere[(x=0.0,y=0.0,z=0.0),r=10.0]
        // sphere02: Sphere[(x=1.0,y=2.0,z=3.0),r=5.0]
        // sphere03: Sphere[(x=11.0,y=11.0,z=11.0),r=10.0]
        // sphere04: Sphere[(x=9.0,y=9.0,z=9.0),r=10.0]

        // Test areaSurround
        System.out.println("areaSurround of sphere01: " + sphere01.areaSurround());
        // areaSurround of sphere01: 1256.6370614359173

        // Test volume
        System.out.println("volume of sphere01: " + sphere01.volume());
        // volume of sphere01: 4188.790204786391

        // Test sphere contains another sphere or not
        System.out.println("sphere01 contains sphere02: " + sphere01.isContainsSphere(sphere02));
        // sphere01 contains sphere02: true
        System.out.println("sphere01 contains sphere04: " + sphere01.isContainsSphere(sphere04));
        // sphere01 contains sphere04: false
        System.out.println("sphere04 contains sphere02: " + sphere04.isContainsSphere(sphere02));
        // sphere01 contains sphere04: false

        // Test sphere intersects another sphere or not
        System.out.println("sphere01 intersects sphere03: " + sphere01.isIntersects(sphere03));
        // sphere01 intersects sphere03: true
        System.out.println("sphere03 intersects sphere04: " + sphere03.isIntersects(sphere04));
        // sphere03 intersects sphere04: true

    }
}
