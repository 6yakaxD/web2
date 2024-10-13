public class Point {

    private final double x;
    private final double y;
    private final double r;
    private final boolean status;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        status = validate(x, y, r);
    }

    private boolean validate(double x, double y, double r) {
        return ((x * x + y * y <= r * r) && (x <= 0) && (y >= 0)) ||
                ((x >= -r) && (x <= 0) && (y <= 0) && (y >= (-r / 2))) ||
                ((y >= x - (r / 2)) && (x >= 0) && (y <= 0));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getStatus() {
        return status;
    }

}