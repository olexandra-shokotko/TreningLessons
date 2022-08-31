package HW8;

public class Quad extends Shape{
    private String name = "Quad";

    public Quad() {
        super.setName(this.name);
    }

    @Override
    public String getName() {
        return name;
    }
}
