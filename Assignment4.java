import java.util.Scanner;
class Point2D{
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String getDetails() {
        return "Point2D(x: " + x + ", y: " + y + ")";
    }

    public boolean isEqual(Point2D other) {
        return this.x == other.x && this.y == other.y;
    }

    public double calculateDistance(Point2D other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}


public class Assignment4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter coordinates of the first point (x1 and y1):");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        
        System.out.println("Enter coordinates of the second point (x2 and y2):");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        
        Point2D p1 = new Point2D(x1, y1);
        Point2D p2 = new Point2D(x2, y2);
        
        System.out.println("Details of Point 1: " + p1.getDetails());
        System.out.println("Details of Point 2: " + p2.getDetails());

        if (p1.isEqual(p2)) {
            System.out.println("The points are located at the same position.");
        } else {
            System.out.println("The points are located at different positions.");
            double distance = p1.calculateDistance(p2);
            System.out.println("The distance between the two points is: " + distance);
        }
        
        sc.close();
    }
}
