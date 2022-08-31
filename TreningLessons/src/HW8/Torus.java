package HW8;

public class Torus extends Shape{
    private String name = "Torus";

    public Torus() {
        super.setName(this.name);
    }

    @Override
    public String getName() {
        return name;
    }
}
