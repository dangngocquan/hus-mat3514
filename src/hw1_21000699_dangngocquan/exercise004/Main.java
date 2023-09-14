package hw1_21000699_dangngocquan.exercise004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create and show spheres
        Sphere sphere01 = new Sphere(5, 0, 0, 0);
        Sphere sphere02 = new Sphere(5, 11, 0, 0);
        Sphere sphere03 = new Sphere(5, 10, 0, 0);
        Sphere sphere04 = new Sphere(5, 9, 0, 0);
        Sphere sphere05 = new Sphere(3, 2, 0, 0);
        Sphere sphere06 = new Sphere(3, 1, 0, 0);
        Sphere sphere07 = new Sphere(3, 0, 0, 0);

        System.out.println("sphere01: " + sphere01);
        System.out.println("sphere02: " + sphere02);
        System.out.println("sphere03: " + sphere03);
        System.out.println("sphere04: " + sphere04);
        System.out.println("sphere05: " + sphere05);
        System.out.println("sphere06: " + sphere06);
        System.out.println("sphere07: " + sphere07);

        // sphere01: Sphere[(x=0.0,y=0.0,z=0.0),r=5.0]
        // sphere02: Sphere[(x=11.0,y=0.0,z=0.0),r=5.0]
        // sphere03: Sphere[(x=10.0,y=0.0,z=0.0),r=5.0]
        // sphere04: Sphere[(x=9.0,y=0.0,z=0.0),r=5.0]
        // sphere05: Sphere[(x=2.0,y=0.0,z=0.0),r=3.0]
        // sphere06: Sphere[(x=1.0,y=0.0,z=0.0),r=3.0]
        // sphere07: Sphere[(x=0.0,y=0.0,z=0.0),r=3.0]

        // Test areaSurround
        System.out.println("areaSurround of sphere01: " + sphere01.areaSurround());
        // areaSurround of sphere01: 314.1592653589793

        // Test volume
        System.out.println("volume of sphere01: " + sphere01.volume());
        // volume of sphere01: 523.5987755982989

        // Test sphere is not intersects another sphere
        System.out.println("sphere01 is outside sphere02: " + sphere01.isOutside(sphere02));
        // sphere01 is outside sphere02: true

        // Test sphere is external contact another sphere
        System.out.println("sphere01 is external contact sphere03: " + sphere01.isExternalContact(sphere03));
        // sphere01 is external contact sphere03: true

        // Test sphere is intersects another sphere
        System.out.println("sphere01 is intersects sphere04: " + sphere01.isIntersects(sphere04));
        // sphere01 is intersects sphere04: true

        // Test sphere is internal contact another sphere
        System.out.println("sphere01 is internal contact sphere05: " + sphere01.isInternalContact(sphere05));
        // sphere01 is internal contact sphere05: true

        // Test sphere is contains another sphere
        System.out.println("sphere01 is contains sphere06: " + sphere01.isContainsSphere(sphere06));
        // sphere01 is contains sphere06: true

        // Test sphere is con another sphere
        System.out.println("sphere01 is concentric sphere07: " + sphere01.isConcentric(sphere07));
        // sphere01 is concentric sphere07: true
    }
}
