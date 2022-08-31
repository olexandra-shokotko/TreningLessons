package HW8;

public class Program {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape torus = new Torus();
        Shape quad = new Quad();
        Shape pyramid = new Pyramid();
        Shape circle = new Circle();
        ShapePrinter shapePrinter = new ShapePrinter();
        shapePrinter.printShape(triangle);
        shapePrinter.printShape(torus);
        shapePrinter.printShape(quad);
        shapePrinter.printShape(pyramid);
        shapePrinter.printShape(circle);
    }
}
