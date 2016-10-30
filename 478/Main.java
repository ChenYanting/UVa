import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            List<Point> points = new ArrayList<>();
            List<Shape> shapes = new ArrayList<>();

            while (true) {
                String input = scanner.next();
                if (input.charAt(0) == '*') {
                    break;
                } else if (input.charAt(0) == 'c') {
                    shapes.add(
                            new Circle(
                                    new Point(scanner.nextDouble(), scanner.nextDouble()),
                                    scanner.nextDouble()
                            )
                    );
                } else if (input.charAt(0) == 't') {
                    shapes.add(
                            new Triangle(
                                    new Point(scanner.nextDouble(), scanner.nextDouble()),
                                    new Point(scanner.nextDouble(), scanner.nextDouble()),
                                    new Point(scanner.nextDouble(), scanner.nextDouble())
                            )
                    );
                } else {
                    shapes.add(
                            new Rectangle(
                                    new Point(scanner.nextDouble(), scanner.nextDouble()),
                                    new Point(scanner.nextDouble(), scanner.nextDouble())
                            )
                    );
                }
            }

            int counter = 1;
            while (scanner.hasNext()) {
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();

                if (x == 9999.9 && y == 9999.9) {
                    break;
                } else {
                    Point point = new Point(x, y);

                    boolean isPointInside = false;
                    for (int i = 0; i < shapes.size(); i++) {
                        if (shapes.get(i).isPointInside(point)) {
                            isPointInside = true;
                            System.out.printf("Point %d is contained in figure %d\n", counter, i + 1);
                        }
                    }

                    if (!isPointInside) {
                        System.out.printf("Point %d is not contained in any figure\n", counter);
                    }

                    counter++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

abstract class Shape {
    public abstract boolean isPointInside(Point point);
}

class Rectangle extends Shape {
    private Point upperLeft;
    private Point lowerRight;

    public Rectangle(Point upperLeft, Point lowerRight) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
    }

    @Override
    public boolean isPointInside(Point point) {
        return (point.getX() > upperLeft.getX() && point.getX() < lowerRight.getX()) && (point.getY() > lowerRight.getY() && point.getY() < upperLeft.getY());
    }

    @Override
    public String toString() {
        return "[" + this.upperLeft + ", " + this.lowerRight + "]";
    }
}

class Circle extends Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isPointInside(Point point) {
        return Math.sqrt(Math.pow(point.getX() - this.center.getX(), 2) + Math.pow(point.getY() - this.center.getY(), 2)) < this.radius;
    }

    @Override
    public String toString() {
        return "[" + this.center + ", " + this.radius + "]";
    }
}

class Triangle extends Shape {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public boolean isPointInside(Point point) {
        //XA
        double CrossXA = point.getX() - this.point1.getX();
        double CrossYA = point.getY() - this.point1.getY();

        //XB
        double CrossXB = point.getX() - this.point2.getX();
        double CrossYB = point.getY() - this.point2.getY();

        //XC
        double CrossXC = point.getX() - this.point3.getX();
        double CrossYC = point.getY() - this.point3.getY();

        double CrossXAXB = CrossXA * CrossYB - CrossYA * CrossXB;
        double CrossXBXC = CrossXB * CrossYC - CrossYB * CrossXC;
        double CrossXCXA = CrossXC * CrossYA - CrossYC * CrossXA;

        if ((CrossXAXB > 0 && CrossXBXC > 0 && CrossXCXA > 0) || (CrossXAXB < 0 && CrossXBXC < 0 && CrossXCXA < 0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "[" + this.point1 + ", " + this.point2 + ", " + this.point3 + "]";
    }
}