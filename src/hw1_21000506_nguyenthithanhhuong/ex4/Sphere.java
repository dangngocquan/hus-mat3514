package hw1_21000506_nguyenthithanhhuong.ex4;

public class Sphere {
    private double radius, x, y, z;

    public Sphere() {
        this.radius = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Sphere(double radius, double x, double y, double z) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // Method get surrounding area of a sphere
    public double surroundArea() {
        return 4 * Math.PI * this.radius * this.radius;
    }

    // Method get volume of a sphere
    public double volume() {
        return 4*1.0/3 * Math.PI * this.radius * this.radius * this.radius;
    }

    // Method test intersection of two spheres
    public static boolean isIntersect(Sphere sphere1, Sphere sphere2) {
        double[] compareCondition = getCompareCondition(sphere1, sphere2);
        return Double.compare(compareCondition[0], compareCondition[1]) < 0
                && Double.compare(compareCondition[1],compareCondition[2]) < 0;
    }

    // Method test touching externally of two spheres
    public static boolean isTouchingExternally(Sphere sphere1, Sphere sphere2) {
        double[] compareCondition = getCompareCondition(sphere1, sphere2);
        return (Double.compare(compareCondition[1], compareCondition[2]) == 0);
    }

    // Method test touching internally of two spheres
    public static boolean isTouchingInternally(Sphere sphere1, Sphere sphere2) {
        double[] compareCondition = getCompareCondition(sphere1, sphere2);
        return (Double.compare(compareCondition[1], compareCondition[0]) == 0);
    }

    // Method test lying outside
    public static boolean isLyingOutside(Sphere sphere1, Sphere sphere2) {
        double[] compareCondition = getCompareCondition(sphere1, sphere2);
        return (Double.compare(compareCondition[1], compareCondition[2]) > 0);
    }

    // Method test lying inside
    public static boolean isLyingInside(Sphere sphere1, Sphere sphere2) {
        double[] compareCondition = getCompareCondition(sphere1, sphere2);
        return (Double.compare(compareCondition[1], compareCondition[0]) < 0);
    }

    // Method test two spheres concentric
    public static boolean isConcentric(Sphere sphere1, Sphere sphere2) {
        return (Double.compare(getDistanceBetweenTwoCenter(sphere1, sphere2), 0) == 0);
    }

    // Method use get distance between two centers of two spheres
    public static double getDistanceBetweenTwoCenter(Sphere sphere1, Sphere sphere2) {
        double dX = (sphere1.x - sphere2.x)*(sphere1.x - sphere2.x);
        double dY = (sphere1.y - sphere2.y)*(sphere1.y - sphere2.y);
        double dZ = (sphere1.z - sphere2.z)*(sphere1.z - sphere2.z);
        return Math.sqrt(dX + dY + dZ);
    }

    // Method use get sum of two radius
    public static double getSumTwoRadius(Sphere sphere1, Sphere sphere2) {
        return sphere1.getRadius() + sphere2.getRadius();
    }

    // Method use get difference of two radius
    public static double getDifferenceTwoRadius(Sphere sphere1, Sphere sphere2) {
        return Math.abs(sphere1.getRadius() - sphere2.getRadius());
    }

    public static double[] getCompareCondition(Sphere sphere1, Sphere sphere2) {
        double[] result = new double[3];
        result[0] = getDifferenceTwoRadius(sphere1, sphere2);
        result[1] = getDistanceBetweenTwoCenter(sphere1, sphere2);
        result[2] = getSumTwoRadius(sphere1, sphere2);
        return result;
    }


    public String toString() {
        return "sphere["
                + "x = " + this.x + ", "
                + "y = " + this.y + ", "
                + "z = " + this.z + ","
                + " radius = " + this.radius
                + "]";
    }
}
