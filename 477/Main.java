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
                    shapes.add(new Circle(new Point(scanner.nextDouble(), scanner.nextDouble()), scanner.nextDouble()));
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

    public boolean isPointInside(Point point) {
        return (point.getX() > upperLeft.getX() && point.getX() < lowerRight.getX()) && (point.getY() > lowerRight.getY() && point.getY() < upperLeft.getY());
    }

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

    public boolean isPointInside(Point point) {
        return Math.sqrt(Math.pow(point.getX() - this.center.getX(), 2) + Math.pow(point.getY() - this.center.getY(), 2)) < this.radius;
    }

    public String toString() {
        return "[" + this.center + ", " + this.radius + "]";
    }
}