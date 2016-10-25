import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            List<Rectangle> rectangles = new ArrayList<>();
            List<Point> points = new ArrayList<>();

            while (true) {
                String input = scanner.next();
                if (input.charAt(0) == '*') {
                    break;
                } else {
                    rectangles.add(
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

                    boolean isPointInsideRectangles = false;
                    for (int i = 0; i < rectangles.size(); i++) {
                        if (rectangles.get(i).isPointInsideTheRectangle(point)) {
                            isPointInsideRectangles = true;
                            System.out.printf("Point %d is contained in figure %d\n", counter, i + 1);
                        }
                    }

                    if (!isPointInsideRectangles) {
                        System.out.printf("Point %d is not contained in any figure\n", counter);
                    }

                    counter++;
                }
            }
        } catch (Exception e) {
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

class Rectangle {
    private Point upperLeft;
    private Point lowerRight;

    public Rectangle(Point upperLeft, Point lowerRight) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
    }

    public boolean isPointInsideTheRectangle(Point point) {
        return (point.getX() > upperLeft.getX() && point.getX() < lowerRight.getX()) && (point.getY() > lowerRight.getY() && point.getY() < upperLeft.getY());
    }

    public String toString() {
        return "[" + this.upperLeft + ", " + this.lowerRight + "]";
    }
}