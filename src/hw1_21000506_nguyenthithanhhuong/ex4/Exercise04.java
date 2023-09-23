package hw1_21000506_nguyenthithanhhuong.ex4;

public class Exercise04 {
    public static void main(String[] args) {
        Sphere sphere1 = new Sphere(5, 0, 0, 0);
        Sphere sphere2 = new Sphere(6, 0, 0, 0);
        Sphere sphere3 = new Sphere(2, 1, 0, 0);
        Sphere sphere4 = new Sphere(5, 12, 9, 0);
        Sphere sphere5 = new Sphere(4, 1, 0, 0);
        Sphere sphere6 = new Sphere(4, 9, 0, 0);
        Sphere sphere7 = new Sphere(2, 6, 0, 0);

        System.out.println("Input spheres...");
        System.out.println("Sphere 1: ");
        System.out.println(sphere1.toString());
        System.out.println("Sphere 2: ");
        System.out.println(sphere2.toString());
        System.out.println("Sphere 3: ");
        System.out.println(sphere3.toString());
        System.out.println("Sphere 4: ");
        System.out.println(sphere4.toString());
        System.out.println("Sphere 5: ");
        System.out.println(sphere5.toString());
        System.out.println("Sphere 6: ");
        System.out.println(sphere6.toString());
        System.out.println("Sphere 7: ");
        System.out.println(sphere7.toString());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Surround area and volume of a sphere...");
        System.out.println("Surround area of sphere 4: ");
        System.out.println(sphere4.surroundArea());
        System.out.println("Volume of sphere 4: ");
        System.out.println(sphere4.volume());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Test relative position of two spheres...");
        System.out.println("1. Test intersect:\n" +
                "Two spheres intersecting each other(sphere1, sphere7)?");
        if (Sphere.isIntersect(sphere1, sphere7)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("2. Test touching externally:\n" +
                "Two spheres touching each other externally(sphere1, sphere6)?");
        if (Sphere.isTouchingExternally(sphere1, sphere6)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("3. Test touching internally:\n" +
                "Two spheres touching each other internally(sphere1, sphere5)?");
        if (Sphere.isTouchingInternally(sphere1, sphere5)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("4. Test lying outside:\n" +
                "Two spheres lying outside each other(sphere1, sphere4)?");
        if (Sphere.isLyingOutside(sphere1, sphere4)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("5. Test lying inside:\n" +
                "One sphere lying inside another(sphere1, sphere3)?");
        if (Sphere.isLyingInside(sphere1, sphere3)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("6. Test concentric: \n" +
              "Two spheres concentric each other(sphere1 , sphere2)?");
        if (Sphere.isConcentric(sphere1, sphere2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // Result
    /*
    Input spheres...
    Sphere 1:
    sphere[x = 0.0, y = 0.0, z = 0.0, radius = 5.0]
    Sphere 2:
    sphere[x = 0.0, y = 0.0, z = 0.0, radius = 6.0]
    Sphere 3:
    sphere[x = 1.0, y = 0.0, z = 0.0, radius = 2.0]
    Sphere 4:
    sphere[x = 12.0, y = 9.0, z = 0.0, radius = 5.0]
    Sphere 5:
    sphere[x = 1.0, y = 0.0, z = 0.0, radius = 4.0]
    Sphere 6:
    sphere[x = 9.0, y = 0.0, z = 0.0, radius = 4.0]
    Sphere 7:
    sphere[x = 6.0, y = 0.0, z = 0.0, radius = 2.0]
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Surround area and volume of a sphere...
    Surround area of sphere 4:
    314.1592653589793
    Volume of sphere 4:
    523.5987755982989
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Test relative position of two spheres...
    1. Test intersect:
    Two spheres intersecting each other(sphere1, sphere7)?
    Yes
    2. Test touching externally:
    Two spheres touching each other externally(sphere1, sphere6)?
    Yes
    3. Test touching internally:
    Two spheres touching each other internally(sphere1, sphere5)?
    Yes
    4. Test lying outside:
    Two spheres lying outside each other(sphere1, sphere4)?
    Yes
    5. Test lying inside:
    One sphere lying inside another(sphere1, sphere3)?
    Yes
    6. Test concentric:
    Two spheres concentric each other(sphere1 , sphere2)?
    Yes
    */
}