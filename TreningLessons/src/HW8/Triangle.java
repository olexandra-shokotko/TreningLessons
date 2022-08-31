package HW8;

public class Triangle extends Shape{
    private String name = "Triangle";

    public Triangle() {
        super.setName(this.name);
    }

    @Override
    public String getName() {
        return name;
    }
}
