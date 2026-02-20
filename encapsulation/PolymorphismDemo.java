public class PolymorphismDemo {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Triangle(3.0, 8.0);

        for (Shape shape : shapes) {
            System.out.println(shape.getShapeInfo());
            System.out.println("Area: " + shape.calculateArea());
        }
    }
}

interface Shape {
    double calculateArea();
    String getShapeInfo();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShapeInfo() {
        return "Circle with radius " + radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getShapeInfo() {
        return "Rectangle with width " + width + " and height " + height;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShapeInfo() {
        return "Triangle with base " + base + " and height " + height;
    }
}
