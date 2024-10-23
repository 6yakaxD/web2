package model;

public class Point {

    private final double x;
    private final double y;
    private final double r;
    private final boolean status;
    private final String localTime;
    private final String executionTime;


    public Point(double x, double y, double r, String localTime, String executionTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.status = validate(x, y, r);
        this.localTime = localTime;
        this.executionTime = executionTime;
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

    public String getLocalTime() {
        return localTime;
    }

    public String getExecutionTime() {
        return executionTime;
    }
}