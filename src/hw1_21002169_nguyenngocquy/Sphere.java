package hw1_21002169_nguyenngocquy;

public class Sphere {
    private double radius;
    private double centerX;
    private double centerY;
    private double centerZ;

    public Sphere(double radius, double centerX, double centerY, double centerZ) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
    }

    public double getRadius() {
        return radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getCenterZ() {
        return centerZ;
    }

    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public String toString() {
        return "Hinh cau co ban kinh " + radius + " va toa do tam (" + centerX + ", " + centerY + ", " + centerZ + ")";
    }

    public static boolean areSpheresOverlapping(Sphere sphere1, Sphere sphere2) {
        double distance = Math.sqrt(
                Math.pow(sphere2.getCenterX() - sphere1.getCenterX(), 2) +
                        Math.pow(sphere2.getCenterY() - sphere1.getCenterY(), 2) +
                        Math.pow(sphere2.getCenterZ() - sphere1.getCenterZ(), 2)
        );
        return distance < (sphere1.getRadius() + sphere2.getRadius());
    }

    public static boolean areSpheresIntersecting(Sphere sphere1, Sphere sphere2) {
        double distance = Math.sqrt(
                Math.pow(sphere2.getCenterX() - sphere1.getCenterX(), 2) +
                        Math.pow(sphere2.getCenterY() - sphere1.getCenterY(), 2) +
                        Math.pow(sphere2.getCenterZ() - sphere1.getCenterZ(), 2)
        );
        return distance <= (sphere1.getRadius() + sphere2.getRadius());
    }

    public static void main(String[] args) {
        Sphere sphere = new Sphere(4.5, 0.0, 0.0, 0.0);

        System.out.println(sphere);
        System.out.println("The tich cua hinh cau la: " + sphere.calculateVolume());
        System.out.println("Dien tich xung quanh cua hinh cau la: " + sphere.calculateSurfaceArea());

        Sphere sphere1 = new Sphere(5.0, 1.0, 2.0, 3.0);
        Sphere sphere2 = new Sphere(4.0, 3.0, 2.0, 1.0);

        boolean areOverlapping = areSpheresOverlapping(sphere1, sphere2);

        boolean areIntersecting = areSpheresIntersecting(sphere1, sphere2);

        System.out.println(sphere1);
        System.out.println(sphere2);

        if (areOverlapping) {
            System.out.println("Hai hinh cau nay bao nhau.");
        } else {
            System.out.println("Hai hinh cau nay khong bao nhau.");
        }

        if (areIntersecting) {
            System.out.println("Hai hinh cau nay giao nhau.");
        } else {
            System.out.println("Hai hinh cau nay khong giao nhau.");
        }

    }
}
