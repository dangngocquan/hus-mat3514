package hw1_21000697_lethinhung.ex4;

public class Sphere {

    private double r;

    private double x;

    private double y;

    private double z;

    public Sphere(double r, double x,
                  double y, double z) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double area() {
        return 4 * Math.PI * r * r;
    }

    public double volume() {
        return 4/3 * Math.PI * Math.pow(r, 3);
    }

    public boolean isCovered(Sphere right) {
        double x1 = this.x - right.getX();
        double y1 = this.y - right.getY();
        double z1 = this.z - right.getZ();
        double distance = Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
        return distance < (this.r + right.getR());
    }

    public boolean isIntersecting(Sphere right) {
        double x1 = this.x - right.getX();
        double y1 = this.y - right.getY();
        double z1 = this.z - right.getZ();
        double distance = Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
        return (distance <= (this.r + right.getR())) && (distance >= Math.abs(this.r - right.getR()));
    }
}
