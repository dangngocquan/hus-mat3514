package hw1_21000699_dangngocquan.exercise004;

public class Sphere {
    private double r;
    private double x;
    private double y;
    private double z;

    public Sphere(double r, double x, double y, double z) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getR() {
        return r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double areaSurround() {
        return 4 * Math.PI * r * r;
    }

    public double volume() {
        return 4.0/3 * Math.PI * r * r * r;
    }

    public boolean isContainsPoint(double x0, double y0, double z0) {
        x0 -= x;
        y0 -= x;
        z0 -= z;
        double d = Math.sqrt(x0*x0 + y0*y0 + z0*z0);
        return d <= r;
    }

    public boolean isContainsSphere(Sphere another) {
        // center A of this sphere
        double xA = x;
        double yA = x;
        double zA = z;
        // center B and radius of another sphere
        double xB = another.getX();
        double yB = another.getY();
        double zB = another.getZ();
        double rB = another.getR();

        if (this.r < rB) return false;
        if (Double.compare(this.r, rB) == 0) {
            return Double.compare(xA, xB) == 0 &&
                    Double.compare(yA, yB) == 0 &&
                    Double.compare(zA, zB) == 0;
        }


        // AB: x = xA + (xB-xA) * t
        //     y = yA + (yB-yA) * t
        //     z = zA + (zB-zA) * t

        double dAB = Math.sqrt((xB-xA)*(xB-xA) + (yB-yA)*(yB-yA) + (zB-zA)*(zB-zA));
        double dAC = dAB + rB;
        double t = dAC / dAB;
        double xC = xA + (xB-xA) * t;
        double yC = yA + (yB-yA) * t;
        double zC = zA + (zB-zA) * t;

        return isContainsPoint(xC, yC, zC);
    }

    public boolean isIntersects(Sphere another) {
        // center A of this sphere
        double xA = x;
        double yA = x;
        double zA = z;
        // center B and radius of another sphere
        double xB = another.getX();
        double yB = another.getY();
        double zB = another.getZ();
        double rB = another.getR();

        double dAB = Math.sqrt((xB-xA)*(xB-xA) + (yB-yA)*(yB-yA) + (zB-zA)*(zB-zA));
        return dAB <= this.r + rB;
    }

    @Override
    public String toString() {
        return String.format("Sphere[(x=%s,y=%s,z=%s),r=%s]", x, y, z, r);
    }
}
