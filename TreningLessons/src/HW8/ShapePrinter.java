package HW8;

import HW8.Shapes.Shape;

public class ShapePrinter implements Printable {
    public ShapePrinter() {
    }

    @Override
    public void printShape(Shape shape) {
        System.out.println(shape.getName());
    }
}