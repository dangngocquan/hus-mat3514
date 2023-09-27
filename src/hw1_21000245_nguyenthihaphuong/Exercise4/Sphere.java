package hw1_21000245_nguyenthihaphuong.Exercise4;

public class Sphere {
    private double r; // Radius
    private double x; // x-coordinate of the center
    private double y; // y-coordinate of the center
    private double z; // z-coordinate of the center

    public Sphere(double r, double x, double y, double z) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setR(double r) {
        this.r = r;
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

    // Calculate the surface area of the sphere
    public double calculateSurfaceArea() {
        return 4 * Math.PI * r * r;
    }

    // Calculate the volume of the sphere
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }

    // Calculate the distance of two sphere
    public double distanceTwoSphere(Sphere otherSphere) {
        return Math.sqrt(Math.pow(this.x - otherSphere.x, 2) +
                Math.pow(this.y - otherSphere.y, 2) +
                Math.pow(this.z - otherSphere.z, 2));
    }

    // Check if two sphere intersect
    public boolean isIntersect(Sphere otherSphere) {
        return distanceTwoSphere(otherSphere) < (this.r + otherSphere.r);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "r=" + r +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
