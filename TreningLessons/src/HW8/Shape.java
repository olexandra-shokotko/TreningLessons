package HW8;

public abstract class Shape implements Printable {
    private String name;

    public Shape() {
    }

    @Override
    public void printShape() {
        System.out.println(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
