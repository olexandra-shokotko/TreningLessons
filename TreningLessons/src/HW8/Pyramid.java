package HW8;

public class Pyramid extends Shape{
    private String name = "Pyramid";

    public Pyramid() {
        super.setName(this.name);
    }

    @Override
    public String getName() {
        return name;
    }
}