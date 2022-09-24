package HW8.Shapes.TwoDimensionalShapes;

import HW8.Shapes.Shape;

public class Circle extends Shape implements TwoDimensionalShape {
    public static final String NAME = "Circle";

    public Circle() {
        super.setName(this.NAME);
    }
}
