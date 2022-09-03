package HW8;

import HW8.Shapes.*;
import HW8.Shapes.ThreeDimensionalShapes.Pyramid;
import HW8.Shapes.ThreeDimensionalShapes.Torus;
import HW8.Shapes.TwoDimensionalShapes.Circle;
import HW8.Shapes.TwoDimensionalShapes.Quad;
import HW8.Shapes.TwoDimensionalShapes.Triangle;

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
