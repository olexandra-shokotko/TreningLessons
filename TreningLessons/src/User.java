public class User {
    private String name;
    private short age;
    private String address;
    private Double money;

    public User(String name) {
        this.name = name;
    }

    public User(String name, short age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
