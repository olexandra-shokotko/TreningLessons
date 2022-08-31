package HW8;

public class Circle extends Shape{
    private String name = "Circle";

    public Circle() {
        super.setName(this.name);
    }

    @Override
    public String getName() {
        return name;
    }
}
